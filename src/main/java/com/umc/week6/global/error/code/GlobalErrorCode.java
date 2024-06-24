package com.umc.week6.global.error.code;

import com.umc.week6.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter // @Getter 어노테이션을 통해 ErrorCode의 메소드들을 오버라이딩
@RequiredArgsConstructor
public enum GlobalErrorCode implements ErrorCode {
    TEST_ERROR(HttpStatus.BAD_REQUEST, "EG001", "테스트를 위한 에러입니다."),
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "EG002", "유효하지 않은 파라미터입니다."),
    MVC_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "EG003", "서버 내부 오류가 발생하였습니다."),
    UNDEFINED_ERROR(null, "EG004", "알 수 없는 오류가 발생하였습니다."),
    PAGE_CANNOT_BE_NEGATIVE(HttpStatus.BAD_REQUEST, "EG000", "페이지 번호는 0 이상의 정수이어야 합니다."),

    ;


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
