package com.javne.SpringApp.dao.impl;


import com.javne.SpringApp.TestDataUtil;
import com.javne.SpringApp.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGenerateCorrectSql() {
        Book book = TestDataUtil.createBookTest();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author) VALUES (?, ?, ?)"),
                eq("1234"),
                eq("Zoo in the stars"),
                eq(1L)

        );
    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSql() {

        underTest.find("1234");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author, id from books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<RowMapper<Book>>any(),
                eq("1234")
        );
    }

    @Test
    public void testThatFindGeneratedCorrectSql(){

        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id from books"),
                ArgumentMatchers.<RowMapper<Book>>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesCorrectSQL(){
        Book book = TestDataUtil.createBookTest();
        underTest.update("1234", book);
        verify(jdbcTemplate).update(
                "Update books SET isbn = ?, title = ?, author_id=? WHERE isbn =?",
                book.getIsbn(),book.getTitle(),book.getAuthorId(),"1234"
        );

    }

    @Test
    public void testThatDeleteGenerateCorrectSQL(){
        underTest.delete("1234");
        verify(jdbcTemplate).update(
                "DELETE FROM books where isbn = ?",
                "1234"
        );
    }

}
