package com.umc.week6.domain.mission.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class MissionRequest {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterMissionRequest {
        @NotNull
        private String content;
        @NotNull
        private int targetPrice;
        @NotNull
        private int reward;
        @NotNull
        private Long storeId;
    }
}
