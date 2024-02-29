package com.icomfortableworld.domain.message.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MessageRequestDto {
    @NotNull(message = "receiverId는 필수입니다.")
    private Long receiverId;

    @NotBlank(message = "content는 필수입니다.")
    private String content;

}
