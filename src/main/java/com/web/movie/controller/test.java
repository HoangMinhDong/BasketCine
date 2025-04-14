package com.web.movie.controller;

import com.web.movie.service.CrawlData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class test {
    private final CrawlData crawlData;

    @RequestMapping("/")
    public void crawlData() throws Exception {
        crawlData.crawlMovies();
    }
}
