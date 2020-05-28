package com.codegym.repository;

import com.codegym.model.Publisher;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {
}
