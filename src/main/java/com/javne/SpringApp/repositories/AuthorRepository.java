package com.javne.SpringApp.repositories;

import com.javne.SpringApp.domain.entities.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    Iterable<AuthorEntity> ageLessThan(int age);

    @Query("SELECT a from Author a where a.age > ?1")
        // 1 to indeksowanie parametrów mozna tez uzyc (@Param("age") int age);
    Iterable<AuthorEntity> findAuthorsWithAgeGreaterThan(int age);
}
