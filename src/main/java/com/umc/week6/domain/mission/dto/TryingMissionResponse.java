package com.umc.week6.domain.mission.dto;

import com.umc.week6.domain.member.dto.MemberResponse;
import com.umc.week6.domain.member.dto.MemberResponse.MemberInfo;
import com.umc.week6.domain.mission.dto.MissionResponse.MissionInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class TryingMissionResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TryingMissionId {
        private Long tryingMissionId;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TryingMissionInfo {
        private Long tryingMissionId;
        private LocalDate dueDate;
        private Boolean isSucceeded;
        private MemberInfo memberInfo;
        private MissionInfo missionInfo;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PagedTryingMissionInfo {
        @Builder.Default
        private List<TryingMissionInfo> tryingMissionInfoList = new ArrayList<>();
        private int page;
        private int totalPages;
        private long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }


}
