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

    /** 전략패턴으로 입력 url 에 따른 로직 실행  */
    public List<Webtoon> parse(String url){
        ParseStrategy parseStrategy = parseFactory.getParseStrategy(url);
        parseFactory.setParseStrategy(parseStrategy);
        List<Webtoon> webtoons = parseFactory.parse(url);
        return webtoons;
    }
}
