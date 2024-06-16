package com.alura.literalura.repository;

import com.alura.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT DISTINCT language FROM Book b INNER JOIN b.languages language")
    List<String> findAllLanguages();

    @Query("SELECT b FROM Book b INNER JOIN b.languages lang WHERE lang = :language")
    List<Book> findBooksByLanguage(String language);
}
