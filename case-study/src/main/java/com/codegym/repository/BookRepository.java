package com.codegym.repository;

import com.codegym.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository  extends PagingAndSortingRepository<Book, Long> {
    Iterable<Book> findAllByCategory(Category category);
    Iterable<Book> findAllByAuthor(Author author);
    Iterable<Book> findAllByLanguage(Language language);
    Iterable<Book> findAllByPublisher(Publisher publisher);

    Page<Book> findAllByBookNameContaining(String bookName, Pageable pageable);
}
