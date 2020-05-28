package com.codegym.service;

import com.codegym.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    //    Iterable<Book> findAll();
    Page<Book> findAll(Pageable pageable);

    Book findById(Long bookID);

    void save(Book book);

    void remove(Long bookID);

    Iterable<Book> findAllByCategory(Category category);

    Iterable<Book> findAllByAuthor(Author author);

    Iterable<Book> findAllByLanguage(Language language);

    Iterable<Book> findAllByPublisher(Publisher publisher);

    Page<Book> findAllByBookNameContaining(String bookName, Pageable pageable);

}