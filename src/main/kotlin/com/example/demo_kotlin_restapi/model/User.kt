package com.example.demo_kotlin_restapi.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String,
    var age: Int,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var photos: List<Photo>
)
