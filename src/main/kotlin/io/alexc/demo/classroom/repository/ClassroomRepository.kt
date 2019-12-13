package io.alexc.demo.classroom.repository

import io.alexc.demo.classroom.entity.Classroom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClassroomRepository : JpaRepository<Classroom, Int> {

    override fun findAll(): List<Classroom>

}