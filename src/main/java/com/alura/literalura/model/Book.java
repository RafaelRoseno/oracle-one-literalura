package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(
        String title,
        List<Author> authors,
        @JsonAlias("id") Integer gutendexId,
        List<String> languages,
        @JsonAlias("download_count") Integer downloadCount
) {

}

