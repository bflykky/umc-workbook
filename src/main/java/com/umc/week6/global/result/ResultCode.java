package com.umc.week6.global.result;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ResultCode {
    private final int status;
    private final String code;
    private final String message;
}
