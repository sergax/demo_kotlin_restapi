package com.example.demo_kotlin_restapi.tools.mapper

import com.example.demo_kotlin_restapi.dto.PhotoDto
import com.example.demo_kotlin_restapi.model.Photo
import org.springframework.stereotype.Component

@Component
class PhotoMapper(
) : Mapper<PhotoDto, Photo> {

    override fun fromEntity(entity: Photo): PhotoDto = PhotoDto(
        entity.id,
        entity.name,
        entity.date,
        entity.description,
        entity.url
    )

    override fun toEntity(dto: PhotoDto): Photo = Photo(
        dto.id,
        dto.name,
        dto.date,
        dto.description,
        dto.url
    )
}

