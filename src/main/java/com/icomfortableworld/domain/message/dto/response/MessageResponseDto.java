package com.icomfortableworld.domain.message.dto.response;

import com.icomfortableworld.domain.message.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponseDto {
    private String fromName;
    private String content;

    public MessageResponseDto(Message message) {
        this.fromName = message.getFromName();
        this.content = message.getContent();
    }
}
