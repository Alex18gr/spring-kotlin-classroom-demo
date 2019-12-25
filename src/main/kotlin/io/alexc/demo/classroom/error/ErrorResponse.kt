package io.alexc.demo.classroom.error

data class ErrorResponse(
        val status: Int,
        val message: String,
        val timeStamp: Long
)