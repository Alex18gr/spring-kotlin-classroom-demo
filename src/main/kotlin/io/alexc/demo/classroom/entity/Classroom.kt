package io.alexc.demo.classroom.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "classrooms")
data class Classroom(
        @Id @Column(name = "classroom_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int,

        @Column(name = "classroom_name")
        var name: String,

        @OneToMany(mappedBy = "classroom", cascade = [CascadeType.ALL]) @JsonManagedReference
        var students: Collection<Student>
)