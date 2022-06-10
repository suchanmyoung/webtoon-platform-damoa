package com.damoawebtoon.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

@Slf4j
@Builder
@Getter
public class Member {

    @NotNull
    private String memberId;

    @NotNull
    private String memberPassword;

    public Member(String memberId, String memberPassword) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
    }
}
