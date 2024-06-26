package com.umc.week6.domain.mission.converter;

import com.umc.week6.domain.member.converter.MemberConverter;
import com.umc.week6.domain.member.entity.Member;
import com.umc.week6.domain.mission.dto.MissionResponse;
import com.umc.week6.domain.mission.dto.TryingMissionResponse;
import com.umc.week6.domain.mission.dto.TryingMissionResponse.PagedTryingMissionInfo;
import com.umc.week6.domain.mission.dto.TryingMissionResponse.TryingMissionId;
import com.umc.week6.domain.mission.dto.TryingMissionResponse.TryingMissionInfo;
import com.umc.week6.domain.mission.entity.Mission;
import com.umc.week6.domain.mission.entity.TryingMission;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Component
public class TryingMissionConverter {
    private final MemberConverter memberConverter;
    private final MissionConverter missionConverter;

    public TryingMission toEntity(Member member, Mission mission, LocalDate dueDate) {
        return TryingMission.builder()
                .id(null)
                .member(member)
                .mission(mission)
                .isSucceeded(false)
                .dueDate(dueDate)
                .build();
    }

    public TryingMissionId toTryingMissionId(Long tryingMissionId) {
        return TryingMissionId.builder()
                .tryingMissionId(tryingMissionId)
                .build();
    }

    public TryingMissionInfo toTryingMissionInfo(TryingMission tryingMission) {
        return TryingMissionInfo.builder()
                .tryingMissionId(tryingMission.getId())
                .dueDate(tryingMission.getDueDate())
                .isSucceeded(tryingMission.isSucceeded())
                .memberInfo(memberConverter.toMemberInfo(tryingMission.getMember()))
                .missionInfo(missionConverter.toMissionInfo(tryingMission.getMission()))
                .build();
    }

    public PagedTryingMissionInfo toPagedTryingMissionId(Page<TryingMission> tryingMissions) {
        List<TryingMissionInfo> tryingMissionInfoList = tryingMissions.stream()
                .map(tryingMission -> toTryingMissionInfo(tryingMission))
                .toList();

        return PagedTryingMissionInfo.builder()
                .tryingMissionInfoList(tryingMissionInfoList)
                .page(tryingMissions.getNumber())
                .totalPages(tryingMissions.getTotalPages())
                .totalElements(tryingMissions.getTotalElements())
                .isFirst(tryingMissions.isFirst())
                .isLast(tryingMissions.isLast())
                .build();
    }
}
