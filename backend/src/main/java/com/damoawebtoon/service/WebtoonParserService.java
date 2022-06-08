package com.damoawebtoon.service;

import com.damoawebtoon.dto.Webtoon;
import com.damoawebtoon.parse.KakaoWebtoon;
import com.damoawebtoon.parse.NaverWebtoon;
import com.damoawebtoon.parse.ParseFactory;
import com.damoawebtoon.parse.ParseStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class WebtoonParserService {

    private final ParseFactory parseFactory;

    /** 전략패턴 & 팩토리로 입력 URL에 적절한 로직 실행  */
    public List<Webtoon> parse(String url){
        ParseStrategy parseStrategy = parseFactory.createParseStrategy(url);
        List<Webtoon> webtoons = parseStrategy.parse(url);
        return webtoons;
    }
}
