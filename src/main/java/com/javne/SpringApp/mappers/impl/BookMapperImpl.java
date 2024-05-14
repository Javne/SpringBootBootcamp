package com.javne.SpringApp.mappers.impl;

import com.javne.SpringApp.domain.dto.BookDto;
import com.javne.SpringApp.domain.entities.BookEntity;
import com.javne.SpringApp.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class BookMapperImpl implements Mapper<BookEntity, BookDto> {


    private ModelMapper modelMapper;

    public BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto mapTo(BookEntity book) {
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public BookEntity mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class);
    }
}
