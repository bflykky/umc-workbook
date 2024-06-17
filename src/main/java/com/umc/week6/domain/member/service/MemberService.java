package com.umc.week6.domain.member.service;

import com.umc.week6.domain.member.dto.MemberRequest.SignupMemberRequest;
import com.umc.week6.domain.member.dto.MemberResponse.MemberId;

public interface MemberService {
    MemberId signup(SignupMemberRequest request);
}
