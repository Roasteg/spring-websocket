package dev.roasteg.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.roasteg.chat.model.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {  
}
