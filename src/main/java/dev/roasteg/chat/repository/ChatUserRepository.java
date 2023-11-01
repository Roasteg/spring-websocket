package dev.roasteg.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.roasteg.chat.model.ChatUser;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {
}
