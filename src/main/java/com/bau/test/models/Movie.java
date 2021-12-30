package com.bau.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie {

    @JsonProperty
    private String Title;
    @JsonProperty
    private String Year;
    @JsonProperty
    private String Rated;
    @JsonProperty
    private String Released;
    @JsonProperty
    private String Runtime;
    @JsonProperty
    private String Genre;
    @JsonProperty
    private String Director;
    @JsonProperty
    private String Writer;
    @JsonProperty
    private String Actors;
    @JsonProperty
    private String Plot;
    @JsonProperty
    private String Language;
    @JsonProperty
    private String Country;
    @JsonProperty
    private String Awards;
    @JsonProperty
    private String Poster;
    @JsonProperty
    private List<Rating> Ratings;
    @JsonProperty
    private String Metascore;
    @JsonProperty
    private String imdbRating;
    @JsonProperty
    private String imdbVotes;
    @JsonProperty
    private String imdbID;
    @JsonProperty
    private String Type;
    @JsonProperty
    private String DVD;
    @JsonProperty
    private String BoxOffice;
    @JsonProperty
    private String Production;
    @JsonProperty
    private String Website;
    @JsonProperty
    private String Response;
}
