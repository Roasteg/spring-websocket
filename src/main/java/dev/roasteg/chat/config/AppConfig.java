package dev.roasteg.chat.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.roasteg.chat.dto.ChatMessageDTO;
import dev.roasteg.chat.model.ChatMessage;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper mapper = new ModelMapper();
        final PropertyMap<ChatMessage, ChatMessageDTO> chatMessageMap = new PropertyMap<ChatMessage,ChatMessageDTO>() {
            protected void configure() {
                map().setText(source.getText());
                map().setUserId(source.getSentByUser().getId());
                map().setUserName(source.getSentByUser().getName());
            }
        };
        mapper.addMappings(chatMessageMap);
        return mapper;
    }
}
