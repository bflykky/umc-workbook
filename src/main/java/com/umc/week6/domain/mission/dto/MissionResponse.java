package com.umc.week6.domain.mission.dto;

import com.umc.week6.domain.store.dto.StoreResponse;
import com.umc.week6.domain.store.dto.StoreResponse.StoreInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class MissionResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionId {
        private Long missionId;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionInfo {
        private Long missionId;
        private String content;
        private int targetPrice;
        private int reward;
        private StoreInfo storeInfo;
        private LocalDate createdAt;
    }


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PagedMissionInfo {
        @Builder.Default
        private List<MissionInfo> missionInfoList = new ArrayList<>();
        private int page;
        private int totalPages;
        private long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}
