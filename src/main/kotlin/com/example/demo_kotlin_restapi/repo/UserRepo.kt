package com.example.demo_kotlin_restapi.repo

import com.example.demo_kotlin_restapi.model.User
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface UserRepo : CrudRepository<User, Int> {
    @EntityGraph(attributePaths = ["photos"])
    fun findAllBy(): List<User>

    @EntityGraph(attributePaths = ["photos"])
    fun findUserById(id: Int): Optional<User>
}

