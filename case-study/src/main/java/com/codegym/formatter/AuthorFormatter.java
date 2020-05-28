package com.codegym.formatter;

import com.codegym.model.Author;
import com.codegym.service.AuthorService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class AuthorFormatter implements Formatter<Author> {

    private AuthorService authorService;

    @Autowired
    public AuthorFormatter(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public Author parse(String text, Locale locale) throws ParseException {
        return authorService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Author object, Locale locale) {
        return "[" + object.getAuthorID() + ", " +object.getAuthorName() + "]";
    }
}
