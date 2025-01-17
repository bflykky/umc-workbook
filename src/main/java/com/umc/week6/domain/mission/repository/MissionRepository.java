package com.umc.week6.domain.mission.repository;

import com.umc.week6.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findByStoreId(Long storeId, Pageable pageable);
}
