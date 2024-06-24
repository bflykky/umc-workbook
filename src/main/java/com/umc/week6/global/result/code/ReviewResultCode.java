package com.umc.week6.global.result.code;

import com.umc.week6.global.result.ResultCode;
import com.umc.week6.global.result.ResultCodeInterface;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ReviewResultCode implements ResultCodeInterface {
    ADD_REVIEW(200, "SR001", "리뷰를 성공적으로 등록하였습니다."),
    STORE_REVIEW_LIST(200, "SR002", "해당 storeId를 가진 가게의 리뷰 목록을 성공적으로 조회하였습니다."),

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


