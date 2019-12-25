package io.alexc.demo.classroom.service

import io.alexc.demo.classroom.entity.Student
import io.alexc.demo.classroom.repository.StudentRepository

class StudentServiceImpl(private val studentRepository: StudentRepository) : StudentService {

    override fun findAll(): MutableList<Student> {
        return studentRepository.findAll()
    }

    override fun <S : Student?> save(student: S): S {
        return studentRepository.save(student)
    }

    override fun delete(student: Student) {
        studentRepository.delete(student)
    }

    override fun deleteById(id: Int) {
        studentRepository.deleteById(id)
    }

    override fun getById(id: Int): Student? {
        return studentRepository.getById(id)
    }

    override fun findByClassroomIdAndId(classroomId: Int, id: Int): Student? {
        return studentRepository.findByClassroom_IdAndId(classroomId, id)
    }
}