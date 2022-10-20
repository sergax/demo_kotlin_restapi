package com.example.demo_kotlin_restapi.service.iml

import com.example.demo_kotlin_restapi.dto.UserDto
import com.example.demo_kotlin_restapi.model.User
import com.example.demo_kotlin_restapi.repo.UserRepo
import com.example.demo_kotlin_restapi.service.UserService
import com.example.demo_kotlin_restapi.tools.mapper.UserMapper
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException
import javax.transaction.Transactional

@Service
class UserServiceImpl(
    private val userRepo: UserRepo,
    private val mapper: UserMapper
) : UserService {
    override fun findAllUsers(): List<UserDto> {
        return userRepo.findAllBy().map { mapper.fromEntity(it) }
    }

    override fun findUserById(id: Int): User {
        return userRepo.findUserById(id).orElseThrow {
            EntityNotFoundException("User by ID: $id not found")
        }
    }

    @Transactional
    override fun createUser(user: User): User {
        return userRepo.save(user)
    }

    @Transactional
    override fun updateUser(id: Int, user: User): User {
        val userById = findUserById(id)
        userById.name = user.name
        userById.age = user.age
        userById.avatar = user.avatar
        return userById
    }

    override fun deleteUser(id: Int) {
        userRepo.deleteById(id)
    }
}