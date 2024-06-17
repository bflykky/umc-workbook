package com.umc.week6.domain.mission.service;

import com.umc.week6.domain.member.entity.Member;
import com.umc.week6.domain.member.service.MemberService;
import com.umc.week6.domain.mission.converter.MissionConverter;
import com.umc.week6.domain.mission.converter.TryingMissionConverter;
import com.umc.week6.domain.mission.dto.MissionRequest.RegisterMissionRequest;
import com.umc.week6.domain.mission.dto.MissionResponse.MissionId;
import com.umc.week6.domain.mission.dto.TryingMissionRequest;
import com.umc.week6.domain.mission.dto.TryingMissionRequest.TryMissionRequest;
import com.umc.week6.domain.mission.dto.TryingMissionResponse;
import com.umc.week6.domain.mission.entity.Mission;
import com.umc.week6.domain.mission.entity.TryingMission;
import com.umc.week6.domain.mission.repository.MissionRepository;
import com.umc.week6.domain.mission.repository.TryingMissionRepository;
import com.umc.week6.domain.store.entity.Store;
import com.umc.week6.domain.store.service.StoreService;
import com.umc.week6.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static com.umc.week6.global.error.code.MissionErrorCode.MISSION_NOT_FOUND;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MissionServiceImpl implements MissionService {
    private final MemberService memberService;
    private final StoreService storeService;
    private final MissionRepository missionRepository;
    private final TryingMissionRepository tryingMissionRepository;
    private final MissionConverter missionConverter;
    private final TryingMissionConverter tryingMissionConverter;


    @Transactional
    @Override
    public MissionId registerMission(RegisterMissionRequest request) {
        Store store = storeService.getStore(request.getStoreId());

        Mission mission = missionConverter.toEntity(request, store);
        missionRepository.save(mission);
        return missionConverter.toMissionId(mission.getId());
    }

    @Transactional
    @Override
    public TryingMissionResponse.TryingMissionId tryMission(TryMissionRequest request) {
        Member member = memberService.getMember(request.getMemberId());
        Mission mission = getMission(request.getMissionId());
        LocalDate dueDate = LocalDate.now().plusDays(7);

        TryingMission tryingMission = tryingMissionConverter.toEntity(member, mission, dueDate);
        tryingMissionRepository.save(tryingMission);
        return tryingMissionConverter.toTryingMissionId(tryingMission.getId());
    }

    @Override
    public Mission getMission(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(() -> new BusinessException(MISSION_NOT_FOUND));
    }
}
