package com.example.demo_kotlin_restapi.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "photos")
data class Photo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String,
    var date: LocalDateTime,
    var description: String,
    var url: String,
)

