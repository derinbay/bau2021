package com.bau.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {

    @JsonProperty
    private String Source;
    @JsonProperty
    private String Value;
}
