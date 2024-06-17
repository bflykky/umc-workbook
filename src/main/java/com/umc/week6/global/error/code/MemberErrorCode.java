package com.umc.week6.global.error.code;

import com.umc.week6.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "EM001", "해당 memberId를 가진 회원이 존재하지 않습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
