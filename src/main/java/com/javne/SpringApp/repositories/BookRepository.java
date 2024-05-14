package com.javne.SpringApp.repositories;

import com.javne.SpringApp.domain.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {
}
