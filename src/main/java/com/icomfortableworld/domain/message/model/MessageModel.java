package com.icomfortableworld.domain.message.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageModel {
    private Long messageId;
    private Long senderId;
    private String receiverId;
    private LocalDateTime createdDate;
}


