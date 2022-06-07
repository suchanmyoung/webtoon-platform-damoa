package com.damoawebtoon.service;

import com.damoawebtoon.dto.Webtoon;
import com.damoawebtoon.util.UrlConnector;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class WebtoonParserServiceTest {

    @Test
    void 테스트(){
        String url = "https://comic.naver.com/webtoon/weekday";
        UrlConnector urlConnector = new UrlConnector();

        List<Webtoon> webtoons = new ArrayList<>();
        Document document = urlConnector.getHtml(url);
        Elements select = document.select(".thumb img");

        for (Element element : select) {
            String title = element.attr("title");
            String thumbnail = element.attr("src");
            webtoons.add(new Webtoon(title, thumbnail));
        }

        assertThat(webtoons).isNotNull();
    }

}