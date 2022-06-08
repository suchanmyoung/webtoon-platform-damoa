package com.damoawebtoon.parse;

import com.damoawebtoon.dto.Webtoon;

import java.util.ArrayList;
import java.util.List;

public interface ParseStrategy {
    List<Webtoon> webtoons = new ArrayList<>();
    List<Webtoon> parse(String url);
    boolean isSupport(String url);
}
