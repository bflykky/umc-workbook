package com.umc.week6.domain.mission.service;

import com.umc.week6.domain.mission.dto.MissionRequest.RegisterMissionRequest;
import com.umc.week6.domain.mission.dto.MissionResponse.MissionId;
import com.umc.week6.domain.mission.dto.MissionResponse.PagedMissionInfo;
import com.umc.week6.domain.mission.dto.TryingMissionRequest.TryMissionRequest;
import com.umc.week6.domain.mission.dto.TryingMissionResponse.TryingMissionId;
import com.umc.week6.domain.mission.entity.Mission;

public interface MissionService {
    MissionId registerMission(RegisterMissionRequest request);
    Mission getMission(Long missionId);
    TryingMissionId tryMission(TryMissionRequest request);
    PagedMissionInfo findMissionListByStoreId(Long storeId, Integer page);
}
