package com.javne.SpringApp.services.Impl;

import com.javne.SpringApp.domain.entities.BookEntity;
import com.javne.SpringApp.repositories.BookRepository;
import com.javne.SpringApp.services.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}
