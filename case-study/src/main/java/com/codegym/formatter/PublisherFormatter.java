package com.codegym.formatter;

import com.codegym.model.Publisher;
import com.codegym.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PublisherFormatter implements Formatter<Publisher> {
    private PublisherService publisherService;

    @Autowired
    public PublisherFormatter(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Override
    public Publisher parse(String text, Locale locale) throws ParseException {
        return publisherService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Publisher object, Locale locale) {
        return "[" + object.getPublisherID() + ", " +object.getPublisherName() + "]";
    }
}
