package com.web.movie.model;

import com.web.movie.util.GenreType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Entity
@Table(name = "tbl_genres")
@AllArgsConstructor
@NoArgsConstructor
public class Genre extends AbstractEntity<Integer>{

    @Enumerated(EnumType.STRING)
    private GenreType genreType;

    @OneToMany(mappedBy = "genre")
    private Set<MovieHasGenre> movieHasGenre;

}
