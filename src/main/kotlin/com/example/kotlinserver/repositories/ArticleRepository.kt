package com.example.kotlinserver.repositories

import com.example.kotlinserver.entities.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findByTitle(title: String): Article?
    fun findAllByOrderByAddedAtDesc() : Iterable<Article>
}