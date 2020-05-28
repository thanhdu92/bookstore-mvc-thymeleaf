package com.codegym.repository;

import com.codegym.model.Language;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LanguageRepository extends PagingAndSortingRepository<Language, Long> {
}
