package io.alexc.demo.classroom.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "students")
data class Student(
        @Id @Column(name = "student_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "first_name", nullable = false)
        val firstName: String,

        @Column(name = "last_name", nullable = false)
        val lastName: String,

        @Column(name = "grade")
        val grade: Float,

        @Column(name = "birth_date", nullable = false)
        @Temporal(TemporalType.DATE)
        val birthDate: Date
)