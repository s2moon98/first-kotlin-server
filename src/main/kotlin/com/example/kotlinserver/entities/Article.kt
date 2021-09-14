package com.example.kotlinserver.entities

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

import com.example.kotlinserver.extensions.toSlug

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var autor: User,
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null,
    var slug: String = title.toSlug()
)