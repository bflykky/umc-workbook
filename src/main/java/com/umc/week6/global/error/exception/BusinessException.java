package com.umc.week6.global.error.exception;

import com.umc.week6.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;
}
