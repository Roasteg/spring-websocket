package dev.roasteg.chat.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.roasteg.chat.exception.UserNotFound;
import dev.roasteg.chat.response.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> userNotFound(UserNotFound exception) {
        final ExceptionResponse response = ExceptionResponse
                .builder()
                .message("User not found! Create a new one.")
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
