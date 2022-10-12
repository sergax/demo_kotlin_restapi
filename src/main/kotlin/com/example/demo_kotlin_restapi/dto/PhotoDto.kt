package com.example.demo_kotlin_restapi.dto

import java.time.LocalDateTime

data class PhotoDto(
    val id: Int,
    val name: String,
    val date: LocalDateTime,
    val description: String,
    val url: String
)
