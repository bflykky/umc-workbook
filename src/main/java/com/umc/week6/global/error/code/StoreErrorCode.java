package com.umc.week6.global.error.code;

import com.umc.week6.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum StoreErrorCode implements ErrorCode {
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "ES001", "해당 storeId를 가진 가게가 존재하지 않습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
