package io.alexc.demo.classroom.service

import io.alexc.demo.classroom.entity.Classroom

interface ClassroomService {

    fun findAll(): List<Classroom>

    fun saveClassroom(classroom: Classroom): Classroom

    fun deleteClassroom(classroom: Classroom)

    fun findById(int: Int): Classroom?
}