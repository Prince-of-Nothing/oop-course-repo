package com.tum.studentmanagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Faculty implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final String field;
    private final List<Student> students = new ArrayList<>();
    private final List<Student> graduates = new ArrayList<>();

    public Faculty(String name, String field) {
        this.name = name.trim();
        this.field = field == null ? "" : field.trim();
    }

    public String getName() { return name; }
    public String getField() { return field; }

    public List<Student> getStudents() { return new ArrayList<>(students); }         // all students currently enrolled
    public List<Student> getEnrolledStudents() { return students.stream().filter(Student::isEnrolled).collect(Collectors.toList()); }
    public List<Student> getGraduates() { return new ArrayList<>(graduates); }

    public void addStudent(Student s) { students.add(s); }

    public void graduateStudent(Student s) {
        s.setEnrolled(false);
        graduates.add(s);
        students.remove(s);
    }

    public boolean hasStudentByEmail(String email) {
        String e = email == null ? "" : email.trim().toLowerCase();
        return students.stream().anyMatch(s -> s.getEmail().equalsIgnoreCase(e))
                || graduates.stream().anyMatch(s -> s.getEmail().equalsIgnoreCase(e));
    }
}