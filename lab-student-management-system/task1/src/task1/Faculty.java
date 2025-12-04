package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Faculty {
    private String name;
    private String abbreviation;
    private StudyField studyField;
    private List<Student> students;

    // Constructor
    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
        this.students = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public String getAbbreviation() { return abbreviation; }
    public StudyField getStudyField() { return studyField; }
    public List<Student> getStudents() { return new ArrayList<>(students); } // returns a copy

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }
    public void setStudyField(StudyField studyField) { this.studyField = studyField; }
    public void setStudents(List<Student> students) { this.students = new ArrayList<>(students); }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Graduate a student by email
    public void graduateStudent(String email) {
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                s.graduate();
                return;
            }
        }
    }

    // Get currently enrolled students
    public List<Student> getEnrolledStudents() {
        return students.stream()
                       .filter(s -> !s.isGraduated())
                       .collect(Collectors.toList());
    }

    // Get graduated students
    public List<Student> getGraduates() {
        return students.stream()
                       .filter(Student::isGraduated)
                       .collect(Collectors.toList());
    }

    // Check if a student belongs to this faculty
    public boolean hasStudent(String email) {
        return students.stream()
                       .anyMatch(s -> s.getEmail().equalsIgnoreCase(email));
    }
}
