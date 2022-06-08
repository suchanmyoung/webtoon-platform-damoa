package com.damoawebtoon.parse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ParseFactory {

    private ParseStrategy parseStrategy = null;

    public ParseStrategy getParseStrategy(String url) {
        return ParseStrategies.chooseStrategy(url);
    }
}
