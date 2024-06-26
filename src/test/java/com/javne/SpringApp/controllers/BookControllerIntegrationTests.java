package com.javne.SpringApp.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.javne.SpringApp.TestDataUtil;
import com.javne.SpringApp.domain.dto.BookDto;
import com.javne.SpringApp.domain.entities.BookEntity;
import com.javne.SpringApp.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class BookControllerIntegrationTests {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private BookService bookService;


    @Autowired
    public BookControllerIntegrationTests(MockMvc mockMvc, BookService bookService) {
        this.mockMvc = mockMvc;
        this.bookService = bookService;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testThatCreateBookSuccessfullyReturnHttp201Created() throws Exception {
        BookEntity bookTest = TestDataUtil.createBookTest(null);
        BookEntity savedBookEntity = bookService.createUpdateBook(
                bookTest.getIsbn(), bookTest
        );

        BookDto bookDto = TestDataUtil.createBookTestDtoA(null);
        bookDto.setIsbn(savedBookEntity.getIsbn());
        String bookJson = objectMapper.writeValueAsString(bookDto);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/books" + bookDto.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatCreateBookSuccessfullyCreatedBook() throws Exception {
        BookDto bookDto = TestDataUtil.createBookTestDtoA(null);
        String bookJson = objectMapper.writeValueAsString(bookDto);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/books" + bookDto.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(bookDto.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value(bookDto.getTitle())
        );
    }

    @Test
    public void testThatCreateBookReturnsHttp200Status() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testThatListBookReturnsBook() throws Exception {
        BookEntity bookTest = TestDataUtil.createBookTest(null);
        bookService.createUpdateBook(bookTest.getIsbn(),bookTest);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].isbn").value(bookTest.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].title").value(bookTest.getTitle())
        );
    }

    @Test
    public void testThatCreateBookReturnsHttp200StatusWhenBookExists() throws Exception {
        BookEntity bookTest = TestDataUtil.createBookTest(null);
        bookService.createUpdateBook(bookTest.getIsbn(),bookTest);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/" + bookTest.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testThatCreateBookReturnsHttp404StatusWhenBookNoExist() throws Exception {
        BookEntity bookTest = TestDataUtil.createBookTest(null);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/" + bookTest.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testThatUpdateBookCreateUpdatedBook() throws Exception {
        BookEntity bookTest = TestDataUtil.createBookTest(null);
        BookEntity savedBookEntity = bookService.createUpdateBook(
                bookTest.getIsbn(), bookTest
        );

        BookDto bookDto = TestDataUtil.createBookTestDtoA(null);
        bookDto.setIsbn(savedBookEntity.getIsbn());
        bookDto.setTitle("Updated");
        String bookJson = objectMapper.writeValueAsString(bookDto);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + bookDto.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value("1234")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("Updated")
        );
    }

    @Test
    public void testThatPartialUpdateBookReturnsStatus200OkStatus() throws Exception {
        BookEntity bookTest = TestDataUtil.createBookTest(null);
        bookService.createUpdateBook(bookTest.getIsbn(),bookTest);

        BookDto bookDto = TestDataUtil.createBookTestDtoA(null);
        bookDto.setTitle("Updated");
        String bookJson = objectMapper.writeValueAsString(bookDto);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/books/" + bookTest.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testThatPartialUpdateBookReturnsUpdatedBook() throws Exception {
        BookEntity bookTest = TestDataUtil.createBookTest(null);
        bookService.createUpdateBook(bookTest.getIsbn(),bookTest);

        BookDto bookDto = TestDataUtil.createBookTestDtoA(null);
        bookDto.setTitle("Updated");
        String bookJson = objectMapper.writeValueAsString(bookDto);

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/books/" + bookTest.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(bookTest.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value("Updated")
        );
    }

    @Test
    public void testThatDeleteNonExistingBookReturnsHttpStatus2024NoFount() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/books/5678" )
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNoContent());
    }


    @Test
    public void testThatDeleteExistingBookReturnsHttpStatus2024NoFount() throws Exception {
        BookEntity bookTest = TestDataUtil.createBookTest(null);
        bookService.createUpdateBook(bookTest.getIsbn(),bookTest);

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/books/" + bookTest.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNoContent());
    }
}


