package io.alexc.demo.classroom.entity

import javax.persistence.*

@Entity
@Table(name = "classrooms")
data class Classroom(
        @Id @Column(name = "classroom_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "classroom_name")
        val name: String
)