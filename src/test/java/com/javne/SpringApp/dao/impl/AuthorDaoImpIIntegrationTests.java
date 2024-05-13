package com.javne.SpringApp.dao.impl;


import com.javne.SpringApp.TestDataUtil;
import com.javne.SpringApp.domain.Author;
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
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImpIIntegrationTests {


    private AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImpIIntegrationTests(AuthorDaoImpl underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){

        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }


    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        Author authorA = TestDataUtil.createTestAuthor();
        underTest.create(authorA);
        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.create(authorB);
        Author authorC = TestDataUtil.createTestAuthorC();
        underTest.create(authorC);

        List<Author> result = underTest.find();
        assertThat(result).hasSize(3).containsExactly(authorA,authorB,authorC);
    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        Author authorA = TestDataUtil.createTestAuthor();
        underTest.create(authorA);

        authorA.setName("Updated");
        underTest.update(authorA.getId(),authorA);
        Optional<Author> result = underTest.findOne(authorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorA);

    }

    @Test
    public void testThatAuthorCanBeDeleted(){
        Author authorA = TestDataUtil.createTestAuthor();
        underTest.create(authorA);
        underTest.delete(authorA.getId());
        Optional<Author> result = underTest.findOne(authorA.getId());
        assertThat(result).isEmpty();
    }
}
