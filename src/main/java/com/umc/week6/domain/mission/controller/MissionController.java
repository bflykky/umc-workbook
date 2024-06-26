package com.umc.week6.domain.mission.controller;

import com.umc.week6.domain.mission.dto.MissionRequest.RegisterMissionRequest;
import com.umc.week6.domain.mission.dto.MissionResponse.MissionId;
import com.umc.week6.domain.mission.dto.MissionResponse.PagedMissionInfo;
import com.umc.week6.domain.mission.dto.TryingMissionRequest.TryMissionRequest;
import com.umc.week6.domain.mission.dto.TryingMissionResponse;
import com.umc.week6.domain.mission.dto.TryingMissionResponse.PagedTryingMissionInfo;
import com.umc.week6.domain.mission.dto.TryingMissionResponse.TryingMissionId;
import com.umc.week6.domain.mission.service.MissionService;
import com.umc.week6.domain.review.controller.validation.CheckPage;
import com.umc.week6.global.error.exception.BusinessException;
import com.umc.week6.global.result.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.umc.week6.global.error.code.GlobalErrorCode.TEST_ERROR;
import static com.umc.week6.global.result.code.MissionResultCode.*;

@RequiredArgsConstructor
@Tag(name = "미션 API", description = "미션 관련 API입니다.")
@RequestMapping("/missions")
@RestController
public class MissionController {
    private final MissionService missionService;

    @GetMapping("/test")
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

    @GetMapping
    @Parameters(value = {
            @Parameter(name = "storeId", description = "미션을 조회할 가게의 storeId를 입력해 주세요."),
            @Parameter(name = "page", description = "page 시작은 0번부터입니다."),
    })
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "storeId를 이용해 특정 가게의 미션 목록을 조회합니다.")
    public ResultResponse<PagedMissionInfo> findReviewListByStoreId(@RequestParam("storeId") Long storeId,
                                                                    @CheckPage @RequestParam("page") Integer page) {
        return ResultResponse.of(STORE_MISSION_LIST, missionService.findMissionListByStoreId(storeId, page));
    }

    @PostMapping("/try")
    public ResultResponse<TryingMissionId> tryMission(@Valid @RequestBody TryMissionRequest request) {
        return ResultResponse.of(TRY_MISSION, missionService.tryMission(request));
    }

    @GetMapping("/try/my")
    @Parameters(value = {
            @Parameter(name = "memberId", description = "자신의 memberId를 입력해 주세요."),
            @Parameter(name = "page", description = "page 시작은 0번부터입니다."),
    })
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "내가 진행하고 있는 미션 목록을 조회합니다.")
    public ResultResponse<PagedTryingMissionInfo> findMyTryingMissionList(@RequestParam("memberId") Long memberId,
                                                                          @CheckPage @RequestParam("page") Integer page) {
        return ResultResponse.of(MY_TRYING_MISSION_LIST, missionService.findMyTryingMissionList(memberId, page));
    }

    @PostMapping("/try/{tryingMissionId}")
    @Parameters(value = {
            @Parameter(name = "tryingMissionId", description = "진행 완료 처리할 진행 중인 미션의 tryingMissionId를 입력해 주세요.")
    })
    @Operation(summary = "미션 진행완료 처리 API", description = "tryingMissionId를 이용해 진행 중인 미션을 진행 완료 처리합니다.")
    public ResultResponse<TryingMissionId> completeMission(@NotNull @PathVariable("tryingMissionId") Long tryingMissionId) {
        return ResultResponse.of(COMPLETE_MISSION, missionService.completeMission(tryingMissionId));
    }
}
