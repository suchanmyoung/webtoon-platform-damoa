package com.damoawebtoon.controller;

import com.damoawebtoon.dto.Webtoon;
import com.damoawebtoon.service.WebtoonParserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class WebtoonParserController {

    private final WebtoonParserService webtoonParserService;

    private String naverWebtoonURL = "https://comic.naver.com/webtoon/weekday";
    private String kakaoWebtoonURL = "https://webtoon.kakao.com/original-webtoon";
    private String lezhinWebtoonURL = "https://www.lezhin.com/ko/scheduled";

    @GetMapping("/naver")
    public ResponseEntity<List<Webtoon>> naverWebtoonParse(){
        List<Webtoon> webtoons = webtoonParserService.parse(naverWebtoonURL);
        return ResponseEntity.ok(webtoons);
    }

    @GetMapping("/kakao")
    public ResponseEntity<List<Webtoon>> kakaoWebtoonParse(){
        List<Webtoon> webtoons = webtoonParserService.parse(kakaoWebtoonURL);
        return ResponseEntity.ok(webtoons);
    }

    @GetMapping("/lezhin")
    public ResponseEntity<List<Webtoon>> lezhinWebtoonParse(){
        List<Webtoon> webtoons = webtoonParserService.parse(lezhinWebtoonURL);
        return ResponseEntity.ok(webtoons);
    }
}
