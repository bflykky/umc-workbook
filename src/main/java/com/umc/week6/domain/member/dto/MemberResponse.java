package com.umc.week6.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberResponse {

    @Getter
    @AllArgsConstructor
    public static class MemberId {
        private Long memberId;
    }
}
