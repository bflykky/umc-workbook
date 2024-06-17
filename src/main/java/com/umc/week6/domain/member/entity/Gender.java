package com.umc.week6.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum Gender {
    MALE, FEMALE, NONE;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Gender get(String input) {
        return Arrays.stream(values())
                .filter(gender -> gender.name().equals(input.toUpperCase()))
                .findAny()
                .orElse(null);
    }
}
