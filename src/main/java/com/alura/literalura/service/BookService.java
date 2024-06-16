package com.alura.literalura.service;

import com.alura.literalura.model.Book;
import com.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public String findAllAvailableLanguages() {
        return String.join(", ", repository.findAllLanguages());
    }

    public List<Book> findAllBooksByLanguage(String language) {
        return repository.findBooksByLanguage(language);
    }

}
