package com.web.movie;

import com.web.movie.service.CrawlData;
import com.web.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
}
