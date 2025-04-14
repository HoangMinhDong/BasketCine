package com.web.movie.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum GenreType {
    @JsonProperty("action")
    ACTION,
    @JsonProperty("comedy")
    COMEDY,
    @JsonProperty("drama")
    DRAMA,
    @JsonProperty("horror")
    HORROR,
    @JsonProperty("romance")
    ROMANCE,
    @JsonProperty("sci-fi")
    SCIFI,
    @JsonProperty("fantasy")
    FANTASY,
    @JsonProperty("thriller")
    THRILLER,
    @JsonProperty("animation")
    ANIMATION,
    @JsonProperty("documentary")
    DOCUMENTARY,
    @JsonProperty("mystery")
    MYSTERY,
    @JsonProperty("adventure")
    ADVENTURE,
    @JsonProperty("crime")
    CRIME,
}
