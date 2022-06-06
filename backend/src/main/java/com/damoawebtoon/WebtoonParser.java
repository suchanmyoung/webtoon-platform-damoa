package com.damoawebtoon;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class WebtoonParser {

    String naverWebtoonURL = "https://comic.naver.com/webtoon/weekday";
    Document document;

    @RequestMapping("/naver")
    public List<Webtoon> naverWebtoonParser(){

        List<Webtoon> webtoons = new ArrayList<>();
        try {

            document = Jsoup.connect(naverWebtoonURL).get();
            Elements select = document.select(".thumb img");
            System.out.println(select);
            for (Element element : select) {
                String title = element.attr("title");
                String thumbnail = element.attr("src");

                webtoons.add(new Webtoon(title, thumbnail));
            }
        } catch (IOException e){
            log.error(e.getMessage());
        }

        for (Webtoon webtoon : webtoons) {
            System.out.println(webtoon.toString());
        }
        return webtoons;
    }
}
