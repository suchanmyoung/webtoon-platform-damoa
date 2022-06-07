package com.damoawebtoon.parse;

import com.damoawebtoon.dto.Webtoon;
import com.damoawebtoon.util.UrlConnector;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class NaverWebtoon implements ParseStrategy{

    @Override
    public List<Webtoon> parse(String url) {
        Document document = UrlConnector.getHtml(url);
        Elements select = document.select(".thumb img");
        for (Element element : select) {
            Webtoon webtoon = new Webtoon(element.attr("title"), element.attr("src"));
            webtoons.add(webtoon);
        }
        return webtoons;
    }
}
