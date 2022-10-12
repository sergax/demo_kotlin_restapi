package com.example.demo_kotlin_restapi.service

import com.example.demo_kotlin_restapi.dto.UserDto
import com.example.demo_kotlin_restapi.model.User

interface UserService {
    fun findAllUsers(): List<UserDto>
    fun findUserById(id: Int): User
    fun createUser(user: User): User
    fun updateUser(id: Int, user: User): User
    fun deleteUser(id: Int)
}

