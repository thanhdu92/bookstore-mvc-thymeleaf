package com.codegym.service.impl;

import com.codegym.model.*;
import com.codegym.repository.BookRepository;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long bookID) {
        return bookRepository.findOne(bookID);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long bookID) {
        bookRepository.delete(bookID);
    }

    @Override
    public Iterable<Book> findAllByCategory(Category category) {
        return bookRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Book> findAllByAuthor(Author author) {
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public Iterable<Book> findAllByLanguage(Language language) {
        return bookRepository.findAllByLanguage(language);
    }

    @Override
    public Iterable<Book> findAllByPublisher(Publisher publisher) {
        return bookRepository.findAllByPublisher(publisher);
    }

    @Override
    public Page<Book> findAllByBookNameContaining(String bookName, Pageable pageable) {
        return bookRepository.findAllByBookNameContaining(bookName, pageable);
    }
}
