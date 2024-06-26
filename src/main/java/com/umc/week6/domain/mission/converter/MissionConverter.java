package com.umc.week6.domain.mission.converter;

import com.umc.week6.domain.mission.dto.MissionRequest.RegisterMissionRequest;
import com.umc.week6.domain.mission.dto.MissionResponse.MissionId;
import com.umc.week6.domain.mission.dto.MissionResponse.MissionInfo;
import com.umc.week6.domain.mission.dto.MissionResponse.PagedMissionInfo;
import com.umc.week6.domain.mission.entity.Mission;
import com.umc.week6.domain.store.converter.StoreConverter;
import com.umc.week6.domain.store.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MissionConverter {
    private final StoreConverter storeConverter;
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

    public MissionInfo toMissionInfo(Mission mission) {
        return MissionInfo.builder()
                .missionId(mission.getId())
                .content(mission.getContent())
                .targetPrice(mission.getTargetPrice())
                .reward(mission.getReward())
                .storeInfo(storeConverter.toStoreInfo(mission.getStore()))
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public PagedMissionInfo toPagedMissionInfo(Page<Mission> missions) {
        List<MissionInfo> missionInfoList = missions.stream()
                .map(mission -> toMissionInfo(mission))
                .toList();

        return PagedMissionInfo.builder()
                .missionInfoList(missionInfoList)
                .page(missions.getNumber())
                .totalPages(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }

}
