package com.umc.week6.domain.member.service;

import com.umc.week6.domain.member.dto.MemberRequest.SignupMemberRequest;
import com.umc.week6.domain.member.dto.MemberResponse.MemberId;
import com.umc.week6.domain.member.entity.Member;

public interface MemberService {
    MemberId signup(SignupMemberRequest request);

    Member getMember(Long memberId);
}
