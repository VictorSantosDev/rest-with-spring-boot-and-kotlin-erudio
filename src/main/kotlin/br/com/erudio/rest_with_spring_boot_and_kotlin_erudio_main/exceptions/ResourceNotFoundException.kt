package br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException (exception: String?): RuntimeException(exception)