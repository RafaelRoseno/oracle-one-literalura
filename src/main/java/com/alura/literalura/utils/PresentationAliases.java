package com.alura.literalura.utils;

public class PresentationAliases {

    public static class Book {
        public static final String BOOK_PRESENTATION_HEADER = "----- Livro -----";
        public static final String BOOK_PRESENTATION_FOOTER = "----- * -----\n";
        public static final String TITLE = "Titulo: %s";
        public static final String LANGUAGE = "Idioma(s): %s";
        public static final String DOWNLOADS_COUNT = "Número de downloads: %d";
        public static final String AUTHOR = "Autor(es): %s";
    }

    public static class Author {
        public static final String AUTHOR_PRESENTATION_HEADER = "----- Autor -----";
        public static final String AUTHOR_PRESENTATION_FOOTER = "----- * -----\n";
        public static final String NAME = "Nome: %s";
        public static final String BOOKS = "Livros: %s";
        public static final String BIRTH_YEAR = "Ano de nascimento: %d";
        public static final String DEATH_YEAR = "Ano de falecimento: %d";
    }
}
