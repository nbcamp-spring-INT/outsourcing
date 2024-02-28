package com.icomfortableworld.domain.message.service;

import com.icomfortableworld.domain.member.model.MemberModel;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icomfortableworld.domain.member.repository.MemberRepository;
import com.icomfortableworld.domain.message.dto.request.MessageRequestDto;
import com.icomfortableworld.domain.message.dto.response.MessageResponseDto;
import com.icomfortableworld.domain.message.entity.Message;
import com.icomfortableworld.domain.message.repository.MessageJpaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageServiceImpl implements MessageService {

    private final MessageJpaRepository messageRepository;
    private final MemberRepository memberRepository;
    @Override
    public List<MessageResponseDto> getMessageList(Long memberId) {
        List<Message> messageList = messageRepository.findByReceiverId(memberId);

        return messageList.stream()
                .map(MessageResponseDto::new)
                .collect(Collectors.toList());
    }
    @Override
    public void sendMessage(MessageRequestDto requestDto, Long senderId) {
        Long receiverId = requestDto.getReceiverId();

        if (senderId.equals(receiverId)) {
            throw new IllegalArgumentException("자신에게 메시지를 보낼 수 없습니다.");
        }
        MemberModel receiver = memberRepository.findByIdOrElseThrow(receiverId);

        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        message.setContent(requestDto.getContent());

        messageRepository.save(message);
    }
}
