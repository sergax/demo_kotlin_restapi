package com.example.demo_kotlin_restapi.repo;

import com.example.demo_kotlin_restapi.model.Photo
import org.springframework.data.jpa.repository.JpaRepository

interface PhotoRepo : JpaRepository<Photo, Int> {
    fun existsPhotoByName(name: String): Boolean

}