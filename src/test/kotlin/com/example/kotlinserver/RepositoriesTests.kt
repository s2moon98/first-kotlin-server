package com.example.kotlinserver

import com.example.kotlinserver.entities.Article
import com.example.kotlinserver.entities.User
import com.example.kotlinserver.repositories.ArticleRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val articleRepository: ArticleRepository
){

    @Test
    fun `When findByIdOrNull then return Article`() {
        // given
        val newUser = User("s2moon98", "jieun", "moon")
        entityManager.persist(newUser)

        var newArticle = Article("new article title", "new headline", "new content", newUser)
        entityManager.persist(newArticle)

        entityManager.flush()

        // when
        // !!의 의미 : null이 들어올 수 없는 경우
        val found = articleRepository.findByIdOrNull(newArticle.id!!)

        // then
        assertThat(found).isEqualTo(newArticle)
    }
}