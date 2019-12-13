package io.alexc.demo.classroom.service

import io.alexc.demo.classroom.entity.Classroom
import io.alexc.demo.classroom.repository.ClassroomRepository
import org.springframework.stereotype.Service

@Service
class ClassroomService(private val classroomRepository: ClassroomRepository) {

    fun findAll(): List<Classroom> {
        return classroomRepository.findAll()
    }

}