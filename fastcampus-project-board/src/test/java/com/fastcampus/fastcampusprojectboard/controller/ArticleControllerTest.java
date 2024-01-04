package com.fastcampus.fastcampusprojectboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }

    @Disabled("구현 중")
    @DisplayName("[view] [GET] 게시글 리스트")
    @Test
    public void givenNoting_whenRequestingArticlesView_thenReturnArticlesView() throws Exception {
        //Given

        //When and Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.view().name("articles/index"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("articles"));


    }

    @Disabled("구현 중")
    @DisplayName("[view] [GET] 게시글 상세페이지")
    @Test
    public void givenNoting_whenRequestingArticlesView_thenReturnArticleView() throws Exception {
        //Given

        //When and Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.view().name("articles/detail"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("article"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("articleComments"));

    }

    @Disabled("구현 중")
    @DisplayName("[view] [GET] 게시글 검색 전용 페이지")
    @Test
    public void givenNoting_whenRequestingArticleSearchView_thenReturnArticleSearchView() throws Exception {
        //Given

        //When and Then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.model().attributeExists("article/search"));

    }

    @Disabled("구현 중")
    @DisplayName("[view] [GET] 게시글 해시테그 검색 페이지")
    @Test
    public void givenNoting_whenRequestingArticleHashtagSearchView_thenReturnArticleSearchView() throws Exception {
        //Given

        //When and Then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.model().attributeExists("article/search-hashtag"));

    }



}