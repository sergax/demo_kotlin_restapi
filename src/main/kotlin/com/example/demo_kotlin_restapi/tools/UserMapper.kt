package com.example.demo_kotlin_restapi.tools

import com.example.demo_kotlin_restapi.dto.UserDto
import com.example.demo_kotlin_restapi.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper(
) : Mapper<UserDto, User> {

    override fun fromEntity(entity: User): UserDto = UserDto(
        entity.id,
        entity.name,
        entity.age,
        entity.photos
    )

    override fun toEntity(dto: UserDto): User = User(
        dto.id,
        dto.name,
        dto.age,
        dto.photos
    )

}