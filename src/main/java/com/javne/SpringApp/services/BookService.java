package com.javne.SpringApp.services;

import com.javne.SpringApp.domain.entities.BookEntity;

public interface BookService {

    BookEntity createBook(String isbn, BookEntity book);


}
