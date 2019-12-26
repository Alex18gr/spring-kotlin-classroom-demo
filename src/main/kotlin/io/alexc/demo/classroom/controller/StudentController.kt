package io.alexc.demo.classroom.controller

import io.alexc.demo.classroom.entity.Classroom
import io.alexc.demo.classroom.entity.Student
import io.alexc.demo.classroom.error.StudentNotFoundException
import io.alexc.demo.classroom.service.StudentService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["students"])
// For fixing the CORS issues due to different domain with the front-end
@CrossOrigin(origins = ["http://localhost:4200"], maxAge = 3600)
class StudentController(private val studentService: StudentService) {

    @RequestMapping(value = [""])
    fun getStudents() : List<Student> {
        return studentService.findAll();
    }

    @RequestMapping(value = ["{id}"])
    fun getStudent(@PathVariable id: Int) : Student {
        return studentService.getById(id) ?: throw StudentNotFoundException(id)
    }

    @RequestMapping(value = ["{id}/classroom"])
    fun getStudentClassroom(@PathVariable id: Int) : Classroom {
        return studentService.getById(id)?.classroom ?: throw StudentNotFoundException(id)
    }

}