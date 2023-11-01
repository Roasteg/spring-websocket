package dev.roasteg.chat.request;

import lombok.Data;

@Data
public class SendMessageRequest {
    private String text;
    private Long userId;
}
