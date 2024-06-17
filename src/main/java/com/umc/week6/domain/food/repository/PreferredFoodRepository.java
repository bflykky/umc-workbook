package com.umc.week6.domain.food.repository;

import com.umc.week6.domain.food.entity.PreferredFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferredFoodRepository extends JpaRepository<PreferredFood, Long> {
}
