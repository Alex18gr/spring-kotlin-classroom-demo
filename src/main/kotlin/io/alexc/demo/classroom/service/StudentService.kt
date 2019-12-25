package io.alexc.demo.classroom.service

import io.alexc.demo.classroom.entity.Student

interface StudentService {

    fun findAll(): MutableList<Student>

    fun <S : Student?> save(student: S): S

    fun delete(student: Student)

    fun deleteById(id: Int)

    fun getById(id: Int): Student?

    fun findByClassroomIdAndId(classroomId: Int, id: Int): Student?

}