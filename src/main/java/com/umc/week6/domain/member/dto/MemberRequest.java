package com.umc.week6.domain.member.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.umc.week6.domain.member.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public abstract class MemberRequest {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignupMemberRequest {
        private boolean locationAgreement;
        private boolean marketingAgreement;
        private String name;
        private Gender gender;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate birthdate;
        private String address;
        private List<Long> preferredFoodList;

        /*
          "locationAgreement": "Boolean",
          "marketingAgreement": "Boolean",
          "name": "String",
          "gender": "String", // enum 형식으로 설정
          "birthDate": "Date", // 2024-05-20 형식
          "address": "String",
          "preferredFoodList": [1, 2, .., n] // foodId Array 형식
         */
    }
}
