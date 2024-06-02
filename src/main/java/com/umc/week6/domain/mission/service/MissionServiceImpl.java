package com.umc.week6.domain.mission.service;

import com.umc.week6.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;

    @Override
    public Long registerMission() {
        return null;
    }
}
