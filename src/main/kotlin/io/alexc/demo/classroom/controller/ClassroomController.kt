package io.alexc.demo.classroom.controller

import io.alexc.demo.classroom.entity.Classroom
import io.alexc.demo.classroom.entity.Student
import io.alexc.demo.classroom.error.ClassroomNotFoundException
import io.alexc.demo.classroom.error.StudentNotFoundException
import io.alexc.demo.classroom.service.ClassroomService
import io.alexc.demo.classroom.service.ClassroomServiceImpl
import io.alexc.demo.classroom.service.StudentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["classrooms"])
// For fixing the CORS issues due to different domain with the front-end
@CrossOrigin(origins = ["http://localhost:4200"], maxAge = 3600)
class ClassroomController(private val classroomService: ClassroomService, private val studentService: StudentService) {

    @RequestMapping(value = [""])
    fun getClassroom(): List<Classroom> {
        return classroomService.findAll()
    }

    @RequestMapping(value = [""], method = [RequestMethod.POST])
    fun postClassroom(@RequestBody classroom: Classroom) : Classroom {
        return classroomService.saveClassroom(classroom)
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET])
    fun getClassroom(@PathVariable id: Int) : Classroom {
        return classroomService.findById(id) ?: throw ClassroomNotFoundException(id)
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.PUT])
    fun putClassroom(@RequestBody classroom: Classroom, @PathVariable id: Int) : Classroom {
        val c = classroomService.findById(id) ?: throw ClassroomNotFoundException(id)
        c.name = classroom.name
        c.students = classroom.students
        return classroomService.saveClassroom(c)
    }

    @RequestMapping(value = ["/{classroomId}/students"])
    fun getClassroomStudents(@PathVariable classroomId: Int) : Collection<Student> {
//        val classroom = classroomService.findById(classroomId)
//        if (classroom != null) return classroom.students
//        else throw ClassroomNotFoundException(classroomId)

        return classroomService.findById(classroomId)?.students ?: throw ClassroomNotFoundException(classroomId)
    }

    @RequestMapping(value = ["/{classroomId}/students"], method = [RequestMethod.POST])
    fun postClassroomStudent(@PathVariable classroomId: Int, @RequestBody student: Student) : Student {
        val classroom = classroomService.findById(classroomId) ?: throw ClassroomNotFoundException(classroomId)
        student.classroom = classroom
        return studentService.save(student)
    }

    @RequestMapping(value = ["/{classroomId}/students/{studentId}"])
    fun getClassroomStudentById(@PathVariable classroomId: Int, @PathVariable studentId: Int) : Student {
        return studentService.findByClassroomIdAndId(classroomId, studentId) ?: throw StudentNotFoundException(studentId)
    }

    @RequestMapping(value = ["/{classroomId}/students/{studentId}"], method = [RequestMethod.PUT])
    fun putClassroomStudent(@PathVariable classroomId: Int, @PathVariable studentId: Int,
                            @RequestBody student: Student) : Student {
        val s = studentService.getById(studentId) ?: throw StudentNotFoundException(studentId)
        s.birthDate = student.birthDate
        s.firstName = student.firstName
        s.lastName = student.lastName
        s.grade = student.grade
        return studentService.save(s)
    }

    @RequestMapping(value = ["/{classroomId}/students/{studentId}"], method = [RequestMethod.DELETE])
    fun deleteClassroomStudent(@PathVariable classroomId: Int, @PathVariable studentId: Int) {
        studentService.delete(studentService.findByClassroomIdAndId(classroomId, studentId)
                ?: throw StudentNotFoundException(studentId, classroomId))
    }

}