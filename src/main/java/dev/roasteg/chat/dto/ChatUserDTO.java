package dev.roasteg.chat.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ChatUserDTO {
    private Long id;
    private String name;
}
