package com.tum.studentmanagement.model;

/** small holder */
public class StudentFacultyPair {
    public final Student student;
    public final Faculty faculty;
    public StudentFacultyPair(Student student, Faculty faculty) {
        this.student = student;
        this.faculty = faculty;
    }
}