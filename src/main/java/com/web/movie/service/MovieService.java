package com.web.movie.service;


import com.web.movie.dto.response.PageResponse;

public interface MovieService {

    PageResponse<?> getMovieList(int pageNo, int pageSize);
}
