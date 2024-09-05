package br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.exceptions.handler

import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.exceptions.ExceptionResponse
import br.com.erudio.rest_with_spring_boot_and_kotlin_erudio_main.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import java.util.*

@ControllerAdvice
@RestController
class CustomizeResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )

        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )

        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}