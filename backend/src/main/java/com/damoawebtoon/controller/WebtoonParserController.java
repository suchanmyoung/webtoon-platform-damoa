package com.damoawebtoon.controller;

import com.damoawebtoon.dto.Webtoon;
import com.damoawebtoon.service.WebtoonParserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class WebtoonParserController {

    private final WebtoonParserService webtoonParserService;

    String naverWebtoonURL = "https://comic.naver.com/webtoon/weekday";
    String kakaoWebtoonURL = "https://webtoon.kakao.com/original-webtoon";


    @RequestMapping("/naver")
    public ResponseEntity<List<Webtoon>> naverWebtoonParse(){
        List<Webtoon> webtoons = webtoonParserService.parse(naverWebtoonURL);
        return ResponseEntity.ok(webtoons);
    }

    @RequestMapping("/kakao")
    public ResponseEntity<List<Webtoon>> kakaoWebtoonParse(){
        List<Webtoon> webtoons = webtoonParserService.parse(kakaoWebtoonURL);
        return ResponseEntity.ok(webtoons);
    }
}
