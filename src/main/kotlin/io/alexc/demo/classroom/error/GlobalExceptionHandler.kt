package io.alexc.demo.classroom.error

import javassist.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.RuntimeException

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class, ClassroomNotFoundException::class, StudentNotFoundException::class)
    fun handleException(exc: RuntimeException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.message ?: "",
                System.currentTimeMillis()
        )

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

}