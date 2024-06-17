package com.umc.week6.domain.mission.controller;

import com.umc.week6.domain.mission.dto.MissionRequest.RegisterMissionRequest;
import com.umc.week6.domain.mission.dto.MissionResponse.MissionId;
import com.umc.week6.domain.mission.service.MissionService;
import com.umc.week6.global.error.exception.BusinessException;
import com.umc.week6.global.result.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.umc.week6.global.error.code.GlobalErrorCode.TEST_ERROR;
import static com.umc.week6.global.result.code.MissionResultCode.MISSION_REGISTERED;
import static com.umc.week6.global.result.code.MissionResultCode.TEST_SUCCESS;

@RequiredArgsConstructor
@Tag(name = "미션 API", description = "미션 관련 API입니다.")
@RequestMapping("/missions")
@RestController
public class MissionController {
    private final MissionService missionService;

    @GetMapping
    @Operation(summary = "8주차 미션 기록용 테스트 API", description = "응답 API의 통일성 확인 및 예외 핸들러의 동작을 확인하기 위한 API입니다.")
    @Parameters(value = {
            @Parameter(name = "input", description = "0 또는 1을 입력해 주세요. 값에 따라 결과가 달라집니다.")
    })
    public ResultResponse<Long> testRequest(@RequestParam("input") int input) {
        if (input == 0) {
            throw new BusinessException(TEST_ERROR);
        }
        return ResultResponse.of(TEST_SUCCESS, 1L);
    }

    @PostMapping
    public ResultResponse<MissionId> registerMission(@Valid @RequestBody RegisterMissionRequest request) {
        return ResultResponse.of(MISSION_REGISTERED, missionService.registerMission(request));
    }
}
