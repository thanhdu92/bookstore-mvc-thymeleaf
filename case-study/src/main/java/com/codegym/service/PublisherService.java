package com.codegym.service;

import com.codegym.model.Publisher;

public interface PublisherService {
    Iterable<Publisher> findAll();

    Publisher findById(Long publisherID);

    void save(Publisher publisher);

    void remove(Long publisherID);
}
