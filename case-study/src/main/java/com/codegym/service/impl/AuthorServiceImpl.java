package com.codegym.service.impl;

import com.codegym.model.Author;
import com.codegym.repository.AuthorRepository;
import com.codegym.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long authorID) {
        return authorRepository.findOne(authorID);
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void remove(Long authorID) {
        authorRepository.delete(authorID);
    }
}
