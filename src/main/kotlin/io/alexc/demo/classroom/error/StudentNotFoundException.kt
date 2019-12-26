package io.alexc.demo.classroom.error

import java.lang.RuntimeException

class StudentNotFoundException : RuntimeException {

    constructor() : super()

    constructor(id: Int) : super("Student with id = $id not found.")

    constructor(studentId: Int, classroomId: Int) : super("Student with id = $studentId not found in classroom with id = $classroomId")

}