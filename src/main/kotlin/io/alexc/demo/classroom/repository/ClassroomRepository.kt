package io.alexc.demo.classroom.repository

import io.alexc.demo.classroom.entity.Classroom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClassroomRepository : JpaRepository<Classroom, Int> {

    override fun findAll(): List<Classroom>

    override fun <S : Classroom?> save(p0: S): S

    override fun delete(p0: Classroom)

    override fun deleteById(id: Int)

    override fun findById(p0: Int): Optional<Classroom>

    fun getByName(name: String): Classroom?

    fun getById(id: Int): Classroom?

}