package dev.roasteg.chat.controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.roasteg.chat.dto.ChatMessageDTO;
import dev.roasteg.chat.dto.ChatUserDTO;
import dev.roasteg.chat.request.AddUserRequest;
import dev.roasteg.chat.request.SendMessageRequest;
import dev.roasteg.chat.service.ChatService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {
    
    private final ChatService chatService;
    private final SimpMessagingTemplate messagingTemplate;

    @PostMapping("/add-user")
    public ChatUserDTO addUser(@RequestBody AddUserRequest request) {
        return chatService.addUser(request.getName());
    }

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody SendMessageRequest request) {
        final ChatMessageDTO message = chatService.sendMessage(request.getUserId(), request.getText());
        this.messagingTemplate.convertAndSend("/chat/messages", message);
    }

}
