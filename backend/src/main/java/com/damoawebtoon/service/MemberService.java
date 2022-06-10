package com.damoawebtoon.service;

import com.damoawebtoon.dto.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class MemberService {
    @PostConstruct
    public void createAdmin(){
        Member.builder()
                .memberId("admin")
                .memberPassword("1234");

        log.info("어드민 계정이 생성되었습니다.");
    }
}
