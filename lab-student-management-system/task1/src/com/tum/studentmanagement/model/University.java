package com.tum.studentmanagement.model;

import com.tum.studentmanagement.util.Utils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * In-memory University aggregate. Serializable for SaveManager persistence.
 */
public class University implements Serializable {
    private static final long serialVersionUID = 1L;

    // keyed by lowercase faculty name
    private final Map<String, Faculty> faculties = new HashMap<>();

    public Faculty createFaculty(String name, String field) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Faculty name required.");
        String key = name.trim().toLowerCase();
        if (faculties.containsKey(key)) throw new IllegalArgumentException("Faculty already exists.");
        Faculty f = new Faculty(name.trim(), field == null ? "" : field.trim());
        faculties.put(key, f);
        return f;
    }

    public Faculty getFaculty(String name) {
        if (name == null) return null;
        return faculties.get(name.trim().toLowerCase());
    }

    public List<Faculty> listFaculties() { return new ArrayList<>(faculties.values()); }

    public List<Faculty> findFacultiesByField(String fieldSubstring) {
        if (fieldSubstring == null) return Collections.emptyList();
        String s = fieldSubstring.trim().toLowerCase();
        return faculties.values().stream()
                .filter(f -> f.getField().toLowerCase().contains(s))
                .collect(Collectors.toList());
    }

    public Student createAndAssignStudent(String name, String email, String facultyName) {
        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty() || facultyName == null || facultyName.trim().isEmpty())
            throw new IllegalArgumentException("Name, email and faculty are required.");
        if (!Utils.validateEmail(email)) throw new IllegalArgumentException("Invalid email format.");
        if (findStudentByEmail(email).student != null) throw new IllegalArgumentException("A student with this email already exists.");
        Faculty f = getFaculty(facultyName);
        if (f == null) {
            f = createFaculty(facultyName, "");
        }
        Student s = new Student(name, email);
        f.addStudent(s);
        return s;
    }

    public StudentFacultyPair findStudentByEmail(String email) {
        if (email == null) return new StudentFacultyPair(null, null);
        String e = email.trim().toLowerCase();
        for (Faculty f : faculties.values()) {
            for (Student s : f.getStudents()) {
                if (s.getEmail().equalsIgnoreCase(e)) return new StudentFacultyPair(s, f);
            }
            for (Student s : f.getGraduates()) {
                if (s.getEmail().equalsIgnoreCase(e)) return new StudentFacultyPair(s, f);
            }
        }
        return new StudentFacultyPair(null, null);
    }

    public void graduateStudentByIdentifier(String identifier) {
        if (identifier == null || identifier.trim().isEmpty()) throw new IllegalArgumentException("Identifier required.");
        String idOrEmail = identifier.trim();
        for (Faculty f : faculties.values()) {
            List<Student> copy = new ArrayList<>(f.getStudents());
            for (Student s : copy) {
                if (s.getId().equals(idOrEmail) || s.getEmail().equalsIgnoreCase(idOrEmail)) {
                    if (!s.isEnrolled()) throw new IllegalArgumentException("Student already graduated.");
                    f.graduateStudent(s);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Can't graduate " + identifier + " (student not present)");
    }

    public boolean doesStudentBelongToFaculty(String email, String facultyName) {
        StudentFacultyPair p = findStudentByEmail(email);
        if (p.student == null || p.faculty == null) return false;
        return p.faculty.getName().trim().equalsIgnoreCase(facultyName.trim());
    }
}