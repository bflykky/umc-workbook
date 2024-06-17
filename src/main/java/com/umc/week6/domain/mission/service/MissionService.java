package com.umc.week6.domain.mission.service;

import com.umc.week6.domain.mission.dto.MissionRequest.RegisterMissionRequest;
import com.umc.week6.domain.mission.dto.MissionResponse.MissionId;

public interface MissionService {
    MissionId registerMission(RegisterMissionRequest request);
}
