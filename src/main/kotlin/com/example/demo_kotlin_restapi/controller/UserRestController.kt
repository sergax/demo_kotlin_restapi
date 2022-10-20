package com.example.demo_kotlin_restapi.controller

import com.example.demo_kotlin_restapi.dto.PhotoDto
import com.example.demo_kotlin_restapi.dto.UserDto
import com.example.demo_kotlin_restapi.model.User
import com.example.demo_kotlin_restapi.service.PhotoService
import com.example.demo_kotlin_restapi.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(
    origins = ["http://localhost:4200/"]
)
class UserRestController(
    private val userService: UserService,
    private val photoService: PhotoService
) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserDto>> {
        return ResponseEntity.ok(userService.findAllUsers())
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Int): ResponseEntity<User> {
        return ResponseEntity.ok(userService.findUserById(id))
    }

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(userService.createUser(user), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Int,
        @RequestBody user: User
    ): ResponseEntity<User> {
        return ResponseEntity.ok(userService.updateUser(id, user))
    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: Int) {
        userService.deleteUser(id)
    }

    @GetMapping("/photos/{photoId}")
    fun getPhotoById(
        @PathVariable photoId: Int,
    ): ResponseEntity<PhotoDto> {
        return ResponseEntity(photoService.findPhotoById(photoId), HttpStatus.CREATED)
    }

    @PostMapping("/{userId}/photos")
    fun createPhoto(
        @PathVariable userId: Int,
        @RequestBody photoDto: PhotoDto
    ): ResponseEntity<PhotoDto> {
        return ResponseEntity(photoService.createPhoto(userId, photoDto), HttpStatus.CREATED)
    }

    @PutMapping("/photos/{photoId}")
    fun updatePhoto(
        @PathVariable photoId: Int,
        @RequestBody photoDto: PhotoDto
    ): ResponseEntity<PhotoDto> {
        return ResponseEntity(photoService.updatePhoto(photoId, photoDto), HttpStatus.CREATED)
    }

}

