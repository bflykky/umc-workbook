package com.umc.week6.domain.food.converter;

import com.umc.week6.domain.food.entity.Food;
import com.umc.week6.domain.food.entity.PreferredFood;
import com.umc.week6.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PreferredFoodConverter {
    public PreferredFood toEntity(Member member, Food food) {
        return PreferredFood.builder()
                .id(null)
                .member(member)
                .food(food)
                .build();
    }
}
