package com.umc.week6.domain.mission.dto;

import com.umc.week6.domain.mission.dto.validation.NotAlreadyTryingMission;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class TryingMissionRequest {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @NotAlreadyTryingMission
    public static class TryMissionRequest {
        @NotNull
        private Long memberId;
        @NotNull
        private Long missionId;
    }
}
