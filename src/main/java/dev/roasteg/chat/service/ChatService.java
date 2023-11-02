package dev.roasteg.chat.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import dev.roasteg.chat.dto.ChatMessageDTO;
import dev.roasteg.chat.dto.ChatUserDTO;
import dev.roasteg.chat.exception.UserNotFound;
import dev.roasteg.chat.model.ChatMessage;
import dev.roasteg.chat.model.ChatUser;
import dev.roasteg.chat.repository.ChatMessageRepository;
import dev.roasteg.chat.repository.ChatUserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatUserRepository chatUserRepository;
    private final ModelMapper mapper;

    public List<ChatMessageDTO> getChatMessages() {
        return chatMessageRepository
                .findAll()
                .stream()
                .map(message -> mapper.map(message, ChatMessageDTO.class))
                .toList();
    }

    public ChatMessageDTO sendMessage(Long userId, String text) {
        final ChatUser chatUser = chatUserRepository
                .findById(userId)
                .orElseThrow(UserNotFound::new);
        final ChatMessage message = ChatMessage
                .builder()
                .text(text)
                .sentByUser(chatUser)
                .build();
        final ChatMessage savedMessage = chatMessageRepository.save(message);
        return mapper.map(savedMessage, ChatMessageDTO.class);
    }

    public ChatUserDTO addUser(String name) {
        final ChatUser user = ChatUser.builder().name(name).build();
        final ChatUser savedUser = chatUserRepository.save(user);
        return mapper.map(savedUser, ChatUserDTO.class);
    }
}
