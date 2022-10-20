package com.example.demo_kotlin_restapi.service

import com.example.demo_kotlin_restapi.dto.PhotoDto
import com.example.demo_kotlin_restapi.model.Photo

interface PhotoService {
    fun findPhotoById(id: Int): PhotoDto
    fun createPhoto(userId: Int, photoDto: PhotoDto): PhotoDto
    fun updatePhoto(id: Int, photoDto: PhotoDto): PhotoDto
}

