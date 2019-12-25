package io.alexc.demo.classroom.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "classrooms")
data class Classroom(
        @Id @Column(name = "classroom_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "classroom_name")
        val name: String,

        @OneToMany(mappedBy = "classroom", cascade = [CascadeType.ALL]) @JsonManagedReference
        val students: Collection<Student>
)