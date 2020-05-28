package com.codegym.formatter;

import com.codegym.model.Language;
import com.codegym.service.AuthorService;
import com.codegym.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class LanguageFormatter implements Formatter<Language> {
    private LanguageService languageService;

    @Autowired
    public LanguageFormatter(LanguageService languageService) {
        this.languageService = languageService;
    }

    @Override
    public Language parse(String text, Locale locale) throws ParseException {
        return languageService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Language object, Locale locale) {
        return "[" + object.getLanguageID() + ", " +object.getBookLanguage() + "]";
    }
}
