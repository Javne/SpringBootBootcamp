package com.javne.SpringApp.services.Impl;

import com.javne.SpringApp.domain.entities.AuthorEntity;
import com.javne.SpringApp.repositories.AuthorRepository;
import com.javne.SpringApp.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
