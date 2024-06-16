package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;

        @JsonAlias("id")
        private Integer gutendexId;

        @ElementCollection(fetch = FetchType.EAGER)
        private List<String> languages;

        @JsonAlias("download_count")
        private Integer downloadCount;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "author_book",
                joinColumns = @JoinColumn(name = "book_id"),
                inverseJoinColumns = @JoinColumn(name = "author_id")
        )
        private List<Author> authors;


}

