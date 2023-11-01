package dev.roasteg.chat.controller;

import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @Controller
    public class SocketController {
        @MessageMapping("/chat/messages")
        public List<ChatMessageDTO> getMessages() {
            return chatService.getChatMessages();
        }
    }

    private final ChatService chatService;
    private final SimpMessagingTemplate messagingTemplate;
    private final SocketController socketController;

    
    @PostMapping("/add-user")
    public ChatUserDTO addUser(@RequestBody AddUserRequest request) {
        return chatService.addUser(request.getName());
    }

    @PostMapping("/send-message")
    public void sendMessage(@Payload SendMessageRequest request) {
        chatService.sendMessage(request.getUserId(), request.getText());
        messagingTemplate.convertAndSend(socketController.getMessages());
    }

}
