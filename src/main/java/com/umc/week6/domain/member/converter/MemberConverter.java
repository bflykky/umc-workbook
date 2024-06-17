package com.umc.week6.domain.member.converter;

import com.umc.week6.domain.member.dto.MemberRequest;
import com.umc.week6.domain.member.dto.MemberRequest.SignupMemberRequest;
import com.umc.week6.domain.member.dto.MemberResponse;
import com.umc.week6.domain.member.dto.MemberResponse.MemberId;
import com.umc.week6.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberConverter {
    public Member toEntity(SignupMemberRequest request) {
        return Member.builder()
                .id(null)
                .name(request.getName())
                .gender(request.getGender())
                .birthdate(request.getBirthdate())
                .address(request.getAddress())
                // 이후 Member 엔티티에 동의항목 필드 추가 시 로직도 추가하기
                .build();
    }

    public MemberId toMemberId(Long memberId) {
        return new MemberId(memberId);
    }
}
