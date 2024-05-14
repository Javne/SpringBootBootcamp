package com.javne.SpringApp;


import com.javne.SpringApp.domain.entities.AuthorEntity;
import com.javne.SpringApp.domain.entities.BookEntity;

public final class TestDataUtil {

    private TestDataUtil() {

    }

    public static AuthorEntity createTestAuthor() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Ewelina")
                .age(37)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Goja")
                .age(50)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Zoja")
                .age(20)
                .build();
    }

    public static BookEntity createBookTest(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1234")
                .title("Zoo in the stars")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createBookTestB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1235")
                .title("Zoo in the sky")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createBookTestC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1236")
                .title("Zoo in the dark")
                .authorEntity(authorEntity)
                .build();
    }
}
