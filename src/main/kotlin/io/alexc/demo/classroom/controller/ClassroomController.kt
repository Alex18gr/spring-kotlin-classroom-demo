package io.alexc.demo.classroom.controller

import io.alexc.demo.classroom.entity.Classroom
import io.alexc.demo.classroom.service.ClassroomService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["classrooms"])
class ClassroomController(private val classroomService: ClassroomService) {

    @RequestMapping(value = [""])
    fun getClassroom(): List<Classroom> {
        return classroomService.findAll()
    }

}