package com.alura.literalura.service;

import com.alura.literalura.model.Book;
import com.alura.literalura.model.BookResponse;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class GutendexService {

    private static final String GUTENDEX_API_URI = "https://gutendex.com/books/?search=";

    public BookRepository bookRepository;
    public AuthorRepository authorRepository;

    @Autowired
    public GutendexService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public List<Book> searchBookByTitle(String title){
        var booksList = getBook(GUTENDEX_API_URI + title.replaceAll(" ", "%20"));

        booksList.forEach(book -> {
            authorRepository.saveAll(book.getAuthors());
            bookRepository.save(book);
        });

        return booksList;
    }

    private static List<Book> getBook(String uri){
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            BookResponse bookResponse = objectMapper.readValue(response.body(), BookResponse.class);
            return bookResponse.results();

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
