package com.umc.week6.domain.mission.converter;

import com.umc.week6.domain.member.entity.Member;
import com.umc.week6.domain.mission.dto.TryingMissionResponse.TryingMissionId;
import com.umc.week6.domain.mission.entity.Mission;
import com.umc.week6.domain.mission.entity.TryingMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class TryingMissionConverter {
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
}
