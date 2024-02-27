package com.icomfortableworld.domain.message.entity;

import com.icomfortableworld.common.entity.Timestamped;
import com.icomfortableworld.domain.message.dto.request.MessageRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "messages")
public class Message extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column(nullable = false)
    private Long senderId;

    @Column(nullable = false)
    private Long receiverId;

    @Column(nullable = false, length = 40)
    private String content;

    public Message(MessageRequestDto requestDto,Long senderId){
        this.content=requestDto.getContent();
        this.senderId=senderId;
    }


}