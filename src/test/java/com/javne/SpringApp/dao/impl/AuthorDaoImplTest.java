package com.javne.SpringApp.dao.impl;


import com.javne.SpringApp.TestDataUtil;
import com.javne.SpringApp.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {


    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;


    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        Author author = TestDataUtil.createTestAuthor();

        underTest.create(author);

        verify(jdbcTemplate).update(
              eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("Ewelina"), eq(37)
        );
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<RowMapper<Author>>any(),
                eq(1L)
                );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(eq("SELECT id, name, age FROM authors"),
                ArgumentMatchers.<RowMapper<Author>>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesCorrectSQL(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.update(author.getId(),author);

        verify(jdbcTemplate).update(
                "UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
                1L,"Ewelina", 39, 1L
        );
    }

    @Test
    public void testThatDeleteGenerateCorrectSQL(){
        underTest.delete(1L);
        verify(jdbcTemplate).update(
                "DELETE FROM authors where id =?",
                1L
        );
    }
}
