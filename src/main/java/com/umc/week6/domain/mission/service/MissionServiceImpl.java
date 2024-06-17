package com.umc.week6.domain.mission.service;

import com.umc.week6.domain.mission.converter.MissionConverter;
import com.umc.week6.domain.mission.dto.MissionRequest.RegisterMissionRequest;
import com.umc.week6.domain.mission.dto.MissionResponse.MissionId;
import com.umc.week6.domain.mission.entity.Mission;
import com.umc.week6.domain.mission.repository.MissionRepository;
import com.umc.week6.domain.store.entity.Store;
import com.umc.week6.domain.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MissionServiceImpl implements MissionService {
    private final StoreService storeService;
    private final MissionRepository missionRepository;
    private final MissionConverter missionConverter;


    @Transactional
    @Override
    public MissionId registerMission(RegisterMissionRequest request) {
        Store store = storeService.getStore(request.getStoreId());

        Mission mission = missionConverter.toEntity(request, store);
        missionRepository.save(mission);
        return missionConverter.toMissionId(mission.getId());
    }
}
