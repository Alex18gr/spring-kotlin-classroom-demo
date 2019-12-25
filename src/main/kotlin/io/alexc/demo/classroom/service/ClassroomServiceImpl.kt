package io.alexc.demo.classroom.service

import io.alexc.demo.classroom.entity.Classroom
import io.alexc.demo.classroom.repository.ClassroomRepository
import org.springframework.stereotype.Service

@Service
class ClassroomServiceImpl(private val classroomRepository: ClassroomRepository) : ClassroomService {

    override fun findAll(): List<Classroom> {
        return classroomRepository.findAll()
    }

    override fun saveClassroom(classroom: Classroom): Classroom {
        return classroomRepository.save(classroom)
    }

    override fun deleteClassroom(classroom: Classroom) {
        classroomRepository.delete(classroom)
    }

    override fun findById(int: Int): Classroom? {
        return classroomRepository.getById(int)
    }

}