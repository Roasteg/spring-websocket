package dev.roasteg.chat.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.roasteg.chat.dto.ChatUserDTO;
import dev.roasteg.chat.request.AddUserRequest;
import dev.roasteg.chat.service.ChatService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ChatUserController {
    private final ChatService chatService;

    @PostMapping("/add-user")
    public ChatUserDTO addUser(@RequestBody AddUserRequest request) {
        return chatService.addUser(request.getName());
    }
}
