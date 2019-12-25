package io.alexc.demo.classroom.controller

import io.alexc.demo.classroom.entity.Classroom
import io.alexc.demo.classroom.service.ClassroomService
import io.alexc.demo.classroom.service.ClassroomServiceImpl
import io.alexc.demo.classroom.service.StudentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["classrooms"])
// For fixing the CORS issues due to different domain with the front-end
@CrossOrigin(origins = ["http://localhost:4200"], maxAge = 3600)
class ClassroomController(private val classroomService: ClassroomService) {

    @RequestMapping(value = [""])
    fun getClassroom(): List<Classroom> {
        return classroomService.findAll()
    }

    @RequestMapping(value = [""], method = [RequestMethod.POST])
    fun postClassroom(@RequestBody classroom: Classroom) : Classroom {
        return classroomService.saveClassroom(classroom)
    }

}