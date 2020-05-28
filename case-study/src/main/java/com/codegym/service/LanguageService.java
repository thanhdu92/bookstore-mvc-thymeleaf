package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Language;

public interface LanguageService {
    Iterable<Language> findAll();

    Language findById(Long languageID);

    void save(Language language);

    void remove(Long languageID);
}
