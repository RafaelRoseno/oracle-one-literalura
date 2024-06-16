package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;

        @JsonAlias("birth_year")
        private Integer birthYear;

        @JsonAlias("death_year")
        private Integer deathYear;

        @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
        private List<Book> books;


}
