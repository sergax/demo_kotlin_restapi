package com.example.demo_kotlin_restapi.repo

import com.example.demo_kotlin_restapi.model.User
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.CrudRepository

interface UserRepo: CrudRepository<User, Int> {
    @EntityGraph(attributePaths = ["photos"])
    fun findAllBy(): List<User>
}

