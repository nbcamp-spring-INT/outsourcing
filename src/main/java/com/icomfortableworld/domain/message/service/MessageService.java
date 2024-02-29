package com.icomfortableworld.domain.message.service;

import com.icomfortableworld.domain.message.dto.request.MessageRequestDto;
import com.icomfortableworld.domain.message.dto.response.MessageResponseDto;
import java.util.List;

public interface MessageService {
    void sendMessage(MessageRequestDto requestDto, Long memberId);
}
