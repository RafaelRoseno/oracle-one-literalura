package com.alura.literalura.controller;

import com.alura.literalura.model.Operation;
import com.alura.literalura.service.AuthorService;
import com.alura.literalura.service.BookService;
import com.alura.literalura.service.GutendexService;
import com.alura.literalura.view.InterfaceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ApplicationController {

    GutendexService gutendexService;
    BookService bookService;
    AuthorService authorService;
    InterfaceView view;
    Scanner scanner;

    @Autowired
    public ApplicationController(GutendexService gutendexService, InterfaceView view, BookService bookService, AuthorService authorService) {
        this.gutendexService = gutendexService;
        this.view = view;
        this.bookService = bookService;
        this.authorService = authorService;
        this.scanner = new Scanner(System.in);
    }

    public void init() {
        while (true) {
            view.showMenu();
            var operationSelected = getMenuOption();
            processOperation(operationSelected);
        }
    }

    private void processOperation(Operation operation) {
        switch (operation.getOperation()) {
            case 1:
                processSearchByTitle(operation);
                break;
            case 2:
                processSearchForRegisteredBooks();
                break;
            case 3:
                processSearchForLanguages(operation);
                break;
            case 4:
                processSearchForAuthors();
                break;
            case 5:
                processSearchAuthorByYear();
                break;
            default:
                System.exit(0);
        }
    }

    private void processSearchByTitle(Operation operation) {
        getBookTitle(operation);
        var searchResponse = gutendexService.searchBookByTitle(operation.getBookName());
        view.showBooks(searchResponse);
    }

    private void processSearchForRegisteredBooks() {
        var searchResponse = bookService.findAllBooks();
        view.showBooks(searchResponse);
    }

    private void processSearchForLanguages(Operation operation) {
        var languages = bookService.findAllAvailableLanguages();
        view.showLanguagesAvailable(languages);
        var languageForSearch = getLanguage();
        var searchResponse = bookService.findAllBooksByLanguage(languageForSearch);
        view.showBooks(searchResponse);
    }

    private void processSearchForAuthors(){
        var searchResponse = authorService.findAllAuthors();
        view.showAuthors(searchResponse);
    }

    private void processSearchAuthorByYear(){
        int year = getYear();
        var searchResponse = authorService.findAuthorsAliveByYear(year);
        view.showAuthors(searchResponse);
    }

    private Operation getMenuOption() {
        int option = 0;

        while (true) {
            try {
                option = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                scanner.nextLine();
                view.invalidInputWarning();
            }
        }

        if (option == 0) {System.exit(0);}

        return new Operation(option);
    }

    private int getYear() {
        int year = 0;

        while (true) {
            try {
                view.insertYear();
                year = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                scanner.nextLine();
                view.invalidInputWarning();
            }
        }

        return year;
    }

    private void getBookTitle(Operation operation) {
        String title = "";

        while (true) {
            try {
                view.insertTitle();
                title = scanner.nextLine();
                if (!title.isEmpty()) {
                    break;
                }
            } catch (Exception e) {
                view.invalidInputWarning();
            }
        }
        operation.setBookName(title);
    }

    private String getLanguage() {
        String language = "";

        while (true) {
            try {
                view.insertLanguage();
                language = scanner.nextLine();
                if (!language.isEmpty()) {
                    break;
                }
            } catch (Exception e) {
                view.invalidInputWarning();
            }
        }
        return language;
    }



}
