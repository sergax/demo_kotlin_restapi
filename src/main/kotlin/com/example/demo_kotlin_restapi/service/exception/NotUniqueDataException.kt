package com.example.demo_kotlin_restapi.service.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
class NotUniqueDataException(message: String?) : RuntimeException(message) {
}
