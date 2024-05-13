package com.javne.SpringApp;


import com.javne.SpringApp.domain.Author;
import com.javne.SpringApp.domain.Book;

public final class TestDataUtil {

    private TestDataUtil() {

    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Ewelina")
                .age(39)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Goja")
                .age(37)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Zoja")
                .age(38)
                .build();
    }

    public static Book createBookTest(final Author author) {
        return Book.builder()
                .isbn("1234")
                .title("Zoo in the stars")
                .author(author)
                .build();
    }

    public static Book createBookTestB(final Author author) {
        return Book.builder()
                .isbn("1235")
                .title("Zoo in the sky")
                .author(author)
                .build();
    }

    public static Book createBookTestC(final Author author) {
        return Book.builder()
                .isbn("1236")
                .title("Zoo in the dark")
                .author(author)
                .build();
    }
}
