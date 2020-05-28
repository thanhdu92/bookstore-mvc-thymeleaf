package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.model.Language;
import com.codegym.repository.AuthorRepository;
import com.codegym.repository.LanguageRepository;
import com.codegym.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;

public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Iterable<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language findById(Long languageID) {
        return languageRepository.findOne(languageID);
    }

    @Override
    public void save(Language language) {
        languageRepository.save(language);
    }

    @Override
    public void remove(Long languageID) {
        languageRepository.delete(languageID);
    }
}
