package com.web.movie.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    private String name;

    private String originName;

    private String description;

    private Integer year;

    private String duration;

    private String posterUrl;

    private String country;

    private String language;

}
