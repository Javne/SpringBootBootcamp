package com.javne.SpringApp.dao.impl;


import com.javne.SpringApp.TestDataUtil;
import com.javne.SpringApp.domain.Author;
import com.javne.SpringApp.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD )
public class BookDaoImplIntegrationTests {

    private BookDaoImpl underTest;
    private AuthorDaoImpl authorDao;

    @Autowired
    public BookDaoImplIntegrationTests(BookDaoImpl underTest, AuthorDaoImpl authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }


    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);
        Book book = TestDataUtil.createBookTest();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.find(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }


    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);

        Book book = TestDataUtil.createBookTest();
        book.setAuthorId(author.getId());
        underTest.create(book);

        Book bookB = TestDataUtil.createBookTestB();
        book.setAuthorId(author.getId());
        underTest.create(bookB);

        Book bookC = TestDataUtil.createBookTestC();
        book.setAuthorId(author.getId());
        underTest.create(bookC);

        List<Book> result = underTest.find();
        assertThat(result).hasSize(3).containsExactly(book, bookB, bookC);

    }

    @Test
    public void testThatBookCanBeUpdated(){
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);

        Book book = TestDataUtil.createBookTest();
        book.setAuthorId(author.getId());
        underTest.create(book);

        book.setTitle("Updated");
        underTest.update(book.getIsbn(), book);

        Optional<Book> result = underTest.find(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatAuthorCanBeDeleted(){
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);

        Book book = TestDataUtil.createBookTest();
        book.setAuthorId(author.getId());
        underTest.create(book);
        underTest.delete(book.getIsbn());

        Optional<Book> result = underTest.find(book.getIsbn());
        assertThat(result).isEmpty();

    }
}
