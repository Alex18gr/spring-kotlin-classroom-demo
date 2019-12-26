package io.alexc.demo.classroom.error

import java.lang.RuntimeException

class ClassroomNotFoundException : RuntimeException {

    constructor() : super() {

    }

    constructor(id: Int) : super("Classroom with id = $id not found.") {

    }

}