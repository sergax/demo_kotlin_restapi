package com.example.demo_kotlin_restapi.service.iml

import com.example.demo_kotlin_restapi.dto.PhotoDto
import com.example.demo_kotlin_restapi.repo.PhotoRepo
import com.example.demo_kotlin_restapi.repo.UserRepo
import com.example.demo_kotlin_restapi.service.exception.NotUniqueDataException
import com.example.demo_kotlin_restapi.service.PhotoService
import com.example.demo_kotlin_restapi.tools.mapper.PhotoMapper
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class PhotoServiceImpl(
    private val photoRepo: PhotoRepo,
    private val userRepo: UserRepo,
    private val photoMapper: PhotoMapper,
) : PhotoService {

    override fun findPhotoById(id: Int): PhotoDto {
        return photoMapper.fromEntity(photoRepo.findById(id).orElseThrow())
    }

    @Transactional
    override fun createPhoto(userId: Int, photoDto: PhotoDto): PhotoDto {
        if (photoRepo.existsPhotoByName(photoDto.name))
            throw NotUniqueDataException("This photo already exists")
        val user = userRepo.findById(userId).orElseThrow()
        val photo = photoMapper.toEntity(photoDto)
        user.photos += photo
        val savedPhoto = photoRepo.save(photo)
        return photoMapper.fromEntity(savedPhoto)
    }

    @Transactional
    override fun updatePhoto(id: Int, photoDto: PhotoDto): PhotoDto {
        val photoById = photoRepo.findById(id).get()
        photoById.name = photoDto.name
        photoById.date = LocalDateTime.now()
        photoById.description = photoDto.description
        photoById.url = photoDto.url
        return photoMapper.fromEntity(photoById)
    }
}

