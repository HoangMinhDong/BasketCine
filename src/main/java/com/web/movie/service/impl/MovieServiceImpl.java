package com.web.movie.service.impl;

import com.web.movie.dto.response.MovieResponse;
import com.web.movie.dto.response.PageResponse;
import com.web.movie.model.Movie;
import com.web.movie.repository.MovieRepository;
import com.web.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public PageResponse<?> getMovieList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo ,pageSize);
        Page<Movie> movies = movieRepository.findAll(pageable);

        List<MovieResponse> response = movies.stream().map(movie -> MovieResponse.builder()
                .name(movie.getName())
                .originName(movie.getOriginName())
                .description(movie.getDescription())
                .year(movie.getYear())
                .duration(movie.getDuration())
                .country(movie.getCountry())
                .language(movie.getLanguage())
                .posterUrl(movie.getPosterUrl())
                .build()).toList();

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPage(movies.getTotalPages())
                .items(response)
                .build();
    }
}
