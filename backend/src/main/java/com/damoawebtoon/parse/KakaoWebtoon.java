package com.damoawebtoon.parse;

import com.damoawebtoon.dto.Webtoon;
import com.damoawebtoon.util.UrlConnector;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class KakaoWebtoon implements ParseStrategy{

    @Override
    public List<Webtoon> parse(String url) {
        Document kakaoDocument = UrlConnector.getHtml(url);
        Elements select = kakaoDocument.select(".w-full bottom-0 left-0 absolute h-full");
        for (Element element : select) {
        }

        return null;
    }

    @Override
    public boolean isSupport(String url) {
        if(url.contains("kakao")) return true;
        else return false;
    }
}
