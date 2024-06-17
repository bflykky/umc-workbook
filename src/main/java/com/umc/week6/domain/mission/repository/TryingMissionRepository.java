package com.umc.week6.domain.mission.repository;

import com.umc.week6.domain.mission.entity.TryingMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TryingMissionRepository extends JpaRepository<TryingMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}
