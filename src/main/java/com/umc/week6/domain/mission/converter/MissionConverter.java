package com.umc.week6.domain.mission.converter;

import com.umc.week6.domain.mission.dto.MissionRequest.RegisterMissionRequest;
import com.umc.week6.domain.mission.dto.MissionResponse;
import com.umc.week6.domain.mission.dto.MissionResponse.MissionId;
import com.umc.week6.domain.mission.entity.Mission;
import com.umc.week6.domain.store.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MissionConverter {
    public Mission toEntity(RegisterMissionRequest request, Store store) {
        return Mission.builder()
                .id(null)
                .content(request.getContent())
                .targetPrice(request.getTargetPrice())
                .reward(request.getReward())
                .store(store)
                .build();
    }

    public MissionId toMissionId(Long missionId) {
        return MissionId.builder()
                .missionId(missionId)
                .build();
    }

}
