package com.example.demo_kotlin_restapi.tools.mapper


interface Mapper<D, E> {
    fun fromEntity(entity: E): D
    fun toEntity(dto: D): E
}