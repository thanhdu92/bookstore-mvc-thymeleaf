package com.codegym.service.impl;

import com.codegym.model.Publisher;
import com.codegym.repository.PublisherRepository;
import com.codegym.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;

public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Iterable<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(Long publisherID) {
        return publisherRepository.findOne(publisherID);
    }

    @Override
    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void remove(Long publisherID) {
        publisherRepository.delete(publisherID);
    }
}
