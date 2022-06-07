package com.damoawebtoon.service;

import com.damoawebtoon.dto.Webtoon;
import com.damoawebtoon.util.UrlConnector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class WebtoonParserService {

정    private final UrlConnector urlConnector;

    public List<Webtoon> parse(String url){
        List<Webtoon> webtoons = new ArrayList<>();
        Document document = urlConnector.getHtml(url);
        Elements select = document.select(".thumb img");

        for (Element element : select) {
            Webtoon webtoon = new Webtoon(element.attr("title"), element.attr("src"));
            webtoons.add(webtoon);
        }

        return webtoons;
    }
}
