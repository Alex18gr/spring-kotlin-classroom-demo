package io.alexc.demo.classroom.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "students")
data class Student(
        @Id @Column(name = "student_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int,

        @Column(name = "first_name", nullable = false)
        var firstName: String,

        @Column(name = "last_name", nullable = false)
        var lastName: String,

        @Column(name = "grade")
        var grade: Float,

        @Column(name = "birth_date", nullable = false)
        @Temporal(TemporalType.DATE)
        var birthDate: Date,

        @ManyToOne @JoinColumn(name = "classroom_id") @JsonBackReference
        var classroom: Classroom
)