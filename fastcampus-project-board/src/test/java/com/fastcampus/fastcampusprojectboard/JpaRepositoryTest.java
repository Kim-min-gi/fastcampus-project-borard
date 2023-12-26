package com.fastcampus.fastcampusprojectboard;

import com.fastcampus.fastcampusprojectboard.config.JpaConfig;
import com.fastcampus.fastcampusprojectboard.domain.Article;
import com.fastcampus.fastcampusprojectboard.repository.ArticleCommentRepository;
import com.fastcampus.fastcampusprojectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
public class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository){
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }


    @DisplayName("select Test")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){
        //Given

        //When
        List<Article> articles = articleRepository.findAll();

        //Then
        assertThat(articles)
                .isNotNull()
                .hasSize(123);

    }

    @DisplayName("insert Test")
    @Test
    void givenTestData_whenInserting_thenWorksFine(){
        //Given
        long previousCount = articleRepository.count();

        //When
        Article savedarticle = articleRepository.save(Article.of("new article","new Content" , "#spring"));

        //Then
        assertThat(articleRepository.count())
                .isEqualTo(previousCount + 1);

    }

    @DisplayName("update Test")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        //Given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        article.setHashtag(updatedHashtag);
        // long previousCount = articleRepository.count();

        //When
        Article savedArticles = articleRepository.saveAndFlush(article);

        //Then
        assertThat(savedArticles)
                .hasFieldOrPropertyWithValue("hashtag", updatedHashtag);

    }

    @DisplayName("delete Test")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){
        //Given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        int deleteCommentsSize = article.getArticleComments().size();

        //When
        articleRepository.delete(article);

        //Then
        assertThat(articleRepository.count())
                .isEqualTo(previousArticleCount - 1);
        assertThat(articleRepository.count())
                .isEqualTo(previousArticleCommentCount - deleteCommentsSize);

    }

}
