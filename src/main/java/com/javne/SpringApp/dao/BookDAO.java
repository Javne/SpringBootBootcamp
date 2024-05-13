package com.javne.SpringApp.dao;

import com.javne.SpringApp.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {

    void create(Book book);

    Optional<Book> find(String isbn);

    List<Book> find();

    void update(String isbn, Book book);

    void delete(String isbn);


}

