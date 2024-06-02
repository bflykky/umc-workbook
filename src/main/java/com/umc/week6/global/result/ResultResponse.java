package com.umc.week6.global.result;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ResultResponse<T> {
    private final int status;
    private final String code;
    private final String message;
    private final T data;

    public ResultResponse(ResultCodeInterface resultCode, T data) {
        this.status = resultCode.getResultCode().getStatus();
        this.code = resultCode.getResultCode().getCode();
        this.message = resultCode.getResultCode().getMessage();
        this.data = data;
    }

    public static <T> ResultResponse<T> of(ResultCodeInterface resultCode) {
        return new ResultResponse<>(resultCode, null);
    }

    public static <T> ResultResponse<T> of(ResultCodeInterface resultCode, T data) {
        return new ResultResponse<>(resultCode, data);
    }
}
