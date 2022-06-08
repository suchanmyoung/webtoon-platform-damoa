package com.damoawebtoon.parse;

import org.springframework.stereotype.Component;

/** 전략의 구체 클래스를 생성하는 팩토리 클래스 */
@Component
public class ParseFactory {
    public ParseStrategy createParseStrategy(String url){
        for (ParseStrategy parseStrategy : ParseStrategies.parseStrategies) {
            if(parseStrategy.isSupport(url)) return parseStrategy;
        }
        return null;
    }
}
