package com.alura.literalura.service;

import com.alura.literalura.model.Book;
import com.alura.literalura.model.BookResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GutendexService {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public List<Book> searchBookByTitle(){
        return getBook("");
    }

    private static List<Book> getBook(String uri){
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://gutendex.com/books/?search=dom%20casmurro"))
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
