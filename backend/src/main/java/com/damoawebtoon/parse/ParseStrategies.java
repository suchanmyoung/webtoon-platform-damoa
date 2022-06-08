package com.damoawebtoon.parse;

import java.util.ArrayList;
import java.util.List;

/**
 * 파싱 전략 등록과 선택을 관리
 */

public class ParseStrategies {
    public static List<ParseStrategy> parseStrategies = new ArrayList<>(){{
        add(new NaverWebtoon());
        add(new KakaoWebtoon());
        add(new LezhinWebtoon());
        add(new BomToon());
    }};

    public static ParseStrategy chooseStrategy(String url){
        for (ParseStrategy parseStrategy : parseStrategies) {
            if(parseStrategy.isSupport(url)) return parseStrategy;
        }
        return null;
    }
}
