package com.web.movie.model;

import com.web.movie.util.GenreType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends AbstractEntity<Integer> {

    private String name;

    private String originName;

    private String description;

    private String posterUrl;

    private String thumbUrl;

    private Integer year;

    private String duration;

    private String country;

    private String language;

    @OneToMany(mappedBy = "movie")
    private Set<MovieHasGenre> genres;

    @OneToMany(mappedBy = "movie")
    private List<Comment> comments;
}