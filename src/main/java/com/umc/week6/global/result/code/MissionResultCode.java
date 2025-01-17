package com.umc.week6.global.result.code;

import com.umc.week6.global.result.ResultCode;
import com.umc.week6.global.result.ResultCodeInterface;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MissionResultCode implements ResultCodeInterface {
    TEST_SUCCESS(200, "SMTEST001", "테스트 요청이 성공적으로 완료되었습니다."),
    MISSION_REGISTERED(200, "SM001", "새 미션을 성공적으로 등록하였습니다."),
    TRY_MISSION(200, "SM002", "새로운 미션을 도전 미션 목록에 성공적으로 추가하였습니다."),
    STORE_MISSION_LIST(200, "SM003", "해당 storeId를 가진 가게의 미션 목록을 성공적으로 조회하였습니다."),
    MY_TRYING_MISSION_LIST(200, "SM000", "내가 진행하고 있는 미션 목록을 성공적으로 조회하였습니다."),
    COMPLETE_MISSION(200, "SM000", "해당 미션을 성공적으로 진행완료 처리하였습니다."),


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
