package com.umc.week6.global.result.code;

import com.umc.week6.global.result.ResultCode;
import com.umc.week6.global.result.ResultCodeInterface;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ReviewResultCode implements ResultCodeInterface {
    ADD_REVIEW(200, "SR001", "리뷰를 성공적으로 등록하였습니다."),

    ;

    private final int status;
    private final String code;
    private final String message;

    @Override
    public ResultCode getResultCode() {
        return ResultCode.builder()
                .status(this.status)
                .code(this.code)
                .message(this.message)
                .build();
    }
}


