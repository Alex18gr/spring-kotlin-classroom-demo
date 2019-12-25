package io.alexc.demo.classroom.repository

import io.alexc.demo.classroom.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Int> {

    override fun findAll(): MutableList<Student>

    override fun <S : Student?> save(p0: S): S

    override fun delete(p0: Student)

    override fun deleteById(p0: Int)

    fun getById(id: Int): Student?

    fun findByClassroom_IdAndId(classroomId: Int, id: Int): Student?

}