package com.alura.literalura.view;

import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.alura.literalura.utils.PresentationAliases.Author.AUTHOR_PRESENTATION_FOOTER;
import static com.alura.literalura.utils.PresentationAliases.Author.AUTHOR_PRESENTATION_HEADER;
import static com.alura.literalura.utils.PresentationAliases.Author.BIRTH_YEAR;
import static com.alura.literalura.utils.PresentationAliases.Author.BOOKS;
import static com.alura.literalura.utils.PresentationAliases.Author.DEATH_YEAR;
import static com.alura.literalura.utils.PresentationAliases.Author.NAME;
import static com.alura.literalura.utils.PresentationAliases.Book.AUTHOR;
import static com.alura.literalura.utils.PresentationAliases.Book.BOOK_PRESENTATION_FOOTER;
import static com.alura.literalura.utils.PresentationAliases.Book.BOOK_PRESENTATION_HEADER;
import static com.alura.literalura.utils.PresentationAliases.Book.DOWNLOADS_COUNT;
import static com.alura.literalura.utils.PresentationAliases.Book.LANGUAGE;
import static com.alura.literalura.utils.PresentationAliases.Book.TITLE;

@Component
public class InterfaceView {

    public void showMenu(){
        System.out.println("Escolha uma opção:");
        System.out.println("1) Buscar livro por título");
        System.out.println("2) Listar livros registrados");
        System.out.println("3) Listar livros por idioma\n");
        System.out.println("4) Listar autores registrados");
        System.out.println("5) Listar autores vivos em um determinado ano\n");
        System.out.println("0) Sair\n");
    }

    public void showBooks(List<Book> books){
        books.forEach(this::bookPresentation);
    }

    public void showAuthors(List<Author> authors){
        authors.forEach(this::authorPresentation);
    }

    public void insertTitle(){
        System.out.println(
                """
                Digite o titulo do livro:
                """
        );
    }

    public void invalidInputWarning() {
        System.out.println(
                """
                Entrada inválida, tente novamente!:
                """
        );
    }

    public void showLanguagesAvailable(String languages) {
        System.out.println(
                """
                Idiomas disponíveis:  """ +" "+ languages
        );
    }

    public void insertLanguage(){
        System.out.println(
                """
                Digite a opção de idioma que deseja buscar:
                """
        );
    }

    public void insertYear() {
        System.out.println(
                """
                Digite o ano:
                """
        );
    }

    private void bookPresentation(Book book){
        System.out.println(BOOK_PRESENTATION_HEADER);
        System.out.printf((TITLE) + "%n", book.getTitle());
        System.out.printf((AUTHOR) + "%n", authorsPresentation(book.getAuthors()));
        System.out.printf((LANGUAGE) + "%n", languagePresentation(book.getLanguages()));
        System.out.printf((DOWNLOADS_COUNT) + "%n", book.getDownloadCount());
        System.out.println(BOOK_PRESENTATION_FOOTER);
    }

    private void authorPresentation(Author author){
        System.out.println(AUTHOR_PRESENTATION_HEADER);
        System.out.printf((NAME) + "%n", author.getName());
        System.out.printf((BIRTH_YEAR) + "%n", author.getBirthYear());
        System.out.printf((DEATH_YEAR) + "%n", author.getDeathYear());
        System.out.printf((BOOKS) + "%n", booksByAuthorPresentation(author.getBooks()));
        System.out.println(AUTHOR_PRESENTATION_FOOTER);
    }

    private String languagePresentation(List<String> languages){
        return String.join(", ", languages);
    }

    private String authorsPresentation(List<Author> authors){
        return authors.stream()
                .map(Author::getName)
                .collect(Collectors.joining(", "));
    }

    private String booksByAuthorPresentation(List<Book> books){
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(", "));
    }



}
