package com.damoawebtoon.parse;

import com.damoawebtoon.dto.Webtoon;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParseFactory {

    private ParseStrategy parseStrategy = null;

    public void setParseStrategy(ParseStrategy parseStrategy) {
        this.parseStrategy = parseStrategy;
    }

    public ParseStrategy getParseStrategy(String url) {
        if(url.contains("naver")) return new NaverWebtoon();
        else if(url.contains("kakao")) return new KakaoWebtoon();
        else if(url.contains("lezhin")) return new LezhinWebtoon();
        else return null;
    }

    public List<Webtoon> parse(String url){
        return parseStrategy.parse(url);
    }
}
