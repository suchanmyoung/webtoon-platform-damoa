package com.damoawebtoon.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Webtoon {
    private String title;
    private String thumbnail;

    public Webtoon(String title, String thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }
}
