package com.javne.SpringApp.controllers;

import com.javne.SpringApp.domain.dto.BookDto;
import com.javne.SpringApp.domain.entities.BookEntity;
import com.javne.SpringApp.mappers.Mapper;
import com.javne.SpringApp.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {


    private Mapper<BookEntity, BookDto> bookMapper;
    private BookService bookService;

    public BookController(Mapper<BookEntity, BookDto> bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto){
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);
        BookDto savedbookDto = bookMapper.mapTo(savedBookEntity);
        return new ResponseEntity<>(savedbookDto, HttpStatus.CREATED);
    }
}
