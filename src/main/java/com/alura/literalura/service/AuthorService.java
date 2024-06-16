package com.alura.literalura.service;

import com.alura.literalura.model.Author;
import com.alura.literalura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> findAllAuthors() {
        return repository.findAll();
    }

    public List<Author> findAuthorsAliveByYear(int year) {
        return repository.findAuthorsAliveInYear(year);
    }
}
