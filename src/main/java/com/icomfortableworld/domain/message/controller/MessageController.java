package com.icomfortableworld.domain.message.controller;

import com.icomfortableworld.common.dto.CommonResponseDto;
import com.icomfortableworld.domain.message.dto.request.MessageRequestDto;
import com.icomfortableworld.domain.message.service.MessageService;
import com.icomfortableworld.jwt.security.MemberDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/version-1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;


    @PostMapping
    public ResponseEntity<CommonResponseDto<Void>> sendMessage(
            @Valid
            @RequestBody MessageRequestDto messageRequestDto,
            @AuthenticationPrincipal MemberDetailsImpl memberDetails) {
        messageService.sendMessage(messageRequestDto, memberDetails.getMember().getMemberId());
        return CommonResponseDto.of(HttpStatus.OK, "메세지 전송 완료.", null);
    }


}
