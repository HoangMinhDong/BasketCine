package com.web.movie.controller;

import com.web.movie.dto.response.ResponseData;
import com.web.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
@Slf4j
public class MovieApiController {

    //test
    private final MovieService movieService;

    @GetMapping("/")
    public ResponseData<?> getMovies(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                     @RequestParam(defaultValue = "5", required = false) int pageSize) {
        // Log the request
        log.info("Request get all movies");
        return new ResponseData<>(HttpStatus.OK.value(), "Get all movies success", movieService.getMovieList(pageNo, pageSize));
    }
}
