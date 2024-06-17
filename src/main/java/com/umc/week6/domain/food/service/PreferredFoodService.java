package com.umc.week6.domain.food.service;

import com.umc.week6.domain.food.entity.Food;
import com.umc.week6.domain.food.entity.PreferredFood;
import com.umc.week6.domain.member.entity.Member;

public interface PreferredFoodService {
    PreferredFood createPreferredFood(Member member, Food food);
}
