package com.umc.week6.domain.food.service;

import com.umc.week6.domain.food.entity.Food;
import com.umc.week6.domain.food.repository.FoodRepository;
import com.umc.week6.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.umc.week6.global.error.code.FoodErrorCode.FOOD_NOT_FOUND;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Override
    public Food getFood(Long foodId) {
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new BusinessException(FOOD_NOT_FOUND));

        return food;
    }
}
