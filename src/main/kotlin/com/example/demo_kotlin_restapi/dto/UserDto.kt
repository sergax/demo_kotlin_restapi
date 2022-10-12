package com.example.demo_kotlin_restapi.dto

import com.example.demo_kotlin_restapi.model.Photo

data class UserDto(
    val id: Int,
    val name: String,
    val age: Int,
    val photoDtos: List<Photo>
)

