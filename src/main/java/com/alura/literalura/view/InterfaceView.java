package com.alura.literalura.view;

import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;

import java.util.List;
import java.util.stream.Collectors;

import static com.alura.literalura.utils.PresentationAliases.Book.AUTHOR;
import static com.alura.literalura.utils.PresentationAliases.Book.BOOK_PRESENTATION_FOOTER;
import static com.alura.literalura.utils.PresentationAliases.Book.BOOK_PRESENTATION_HEADER;
import static com.alura.literalura.utils.PresentationAliases.Book.DOWNLOADS_COUNT;
import static com.alura.literalura.utils.PresentationAliases.Book.LANGUAGE;
import static com.alura.literalura.utils.PresentationAliases.Book.TITLE;

public class InterfaceView {

    public void showMenu(){
        System.out.println("Menu...");
    }

    public void showBooks(List<Book> books){
        books.forEach(this::bookPresentation);
    }

    private void bookPresentation(Book book){
        System.out.println(BOOK_PRESENTATION_HEADER);
        System.out.printf((TITLE) + "%n", book.title());
        System.out.printf((AUTHOR) + "%n", authorsPresentation(book.authors()));
        System.out.printf((LANGUAGE) + "%n", languagePresentation(book.languages()));
        System.out.printf((DOWNLOADS_COUNT) + "%n", book.downloadCount());
        System.out.println(BOOK_PRESENTATION_FOOTER);
    }

    private String languagePresentation(List<String> languages){
        return String.join(", ", languages);
    }

    private String authorsPresentation(List<Author> authors){
        return authors.stream()
                .map(Author::name)
                .collect(Collectors.joining(", "));
    }

}
