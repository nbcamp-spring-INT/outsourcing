package com.icomfortableworld.domain.message.dto.response;

import com.icomfortableworld.domain.message.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponseDto {
    private Long senderId;
    private String content;

    public MessageResponseDto(Message message) {
        this.senderId = message.getSenderId();
        this.content = message.getContent();
    }
}
