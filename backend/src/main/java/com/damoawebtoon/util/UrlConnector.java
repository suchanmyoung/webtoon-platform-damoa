package com.damoawebtoon.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UrlConnector {

    public static Document getHtml(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e){
            throw new IllegalArgumentException("잘못된 URL 입니다.");
        }
    }
}
