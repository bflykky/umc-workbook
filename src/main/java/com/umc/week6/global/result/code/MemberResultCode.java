package com.umc.week6.global.result.code;

import com.umc.week6.global.result.ResultCode;
import com.umc.week6.global.result.ResultCodeInterface;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MemberResultCode implements ResultCodeInterface {
    SIGNUP(200, "SME001", "회원가입이 성공적으로 완료되었습니다."),

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


