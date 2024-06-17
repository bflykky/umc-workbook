package com.umc.week6.domain.member.service;

import com.umc.week6.domain.food.entity.Food;
import com.umc.week6.domain.food.entity.PreferredFood;
import com.umc.week6.domain.food.service.FoodService;
import com.umc.week6.domain.food.service.PreferredFoodService;
import com.umc.week6.domain.food.service.PreferredFoodServiceImpl;
import com.umc.week6.domain.member.converter.MemberConverter;
import com.umc.week6.domain.member.dto.MemberRequest.SignupMemberRequest;
import com.umc.week6.domain.member.dto.MemberResponse;
import com.umc.week6.domain.member.dto.MemberResponse.MemberId;
import com.umc.week6.domain.member.entity.Member;
import com.umc.week6.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final FoodService foodService;
    private final PreferredFoodService preferredFoodService;
    private final MemberRepository memberRepository;
    private final MemberConverter memberConverter;

    @Transactional
    @Override
    public MemberId signup(SignupMemberRequest request) {
        Member member = memberConverter.toEntity(request);
        memberRepository.save(member);

        List<Long> foodIdList = request.getPreferredFoodList();
        List<PreferredFood> preferredFoodList = foodIdList.stream()
                .map(foodId -> foodService.getFood(foodId))
                .map(food -> preferredFoodService.createPreferredFood(member, food))
                .collect(Collectors.toList());

        preferredFoodList
                .forEach(preferredFood -> member.addPreferredFood(preferredFood));

        return memberConverter.toMemberId(member.getId());
    }
}
