package com.umc.week6.domain.food.service;

import com.umc.week6.domain.food.converter.PreferredFoodConverter;
import com.umc.week6.domain.food.entity.Food;
import com.umc.week6.domain.food.entity.PreferredFood;
import com.umc.week6.domain.food.repository.PreferredFoodRepository;
import com.umc.week6.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PreferredFoodServiceImpl implements PreferredFoodService {
    private final PreferredFoodRepository preferredFoodRepository;
    private final PreferredFoodConverter preferredFoodConverter;


    public PreferredFood createPreferredFood(Member member, Food food) {
        return preferredFoodConverter.toEntity(member, food);
    }
}
