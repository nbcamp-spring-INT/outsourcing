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
    private String fromName;

    @Column(nullable = false)
    private String toName;

    @Column(nullable = false, length = 40)
    private String content;

    @Column(nullable = false)
    private boolean isRead;

    public Message(MessageRequestDto requestDto,String fromName){
        this.content=requestDto.getContent();
        this.fromName=fromName;
        this.isRead = false;
    }

    public void readMessage(){
        this.isRead = true;
    }
}