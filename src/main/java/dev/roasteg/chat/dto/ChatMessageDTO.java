package dev.roasteg.chat.dto;

import lombok.Data;

@Data
public class ChatMessageDTO {
    private String text;
    private Long sentByUser;
}