package com.umc.week6.domain.member.controller;

import com.umc.week6.domain.member.dto.MemberRequest.SignupMemberRequest;
import com.umc.week6.domain.member.dto.MemberResponse.MemberId;
import com.umc.week6.domain.member.service.MemberService;
import com.umc.week6.global.result.ResultResponse;
import com.umc.week6.global.result.code.MemberResultCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/members")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResultResponse<MemberId> signup(@Valid @RequestBody SignupMemberRequest request) {
        return ResultResponse.of(MemberResultCode.SIGNUP, memberService.signup(request));

    }
}
