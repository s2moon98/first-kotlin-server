package com.example.kotlinserver.repositories

import com.example.kotlinserver.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
}