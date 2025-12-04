package com.tum.studentmanagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import com.tum.studentmanagement.logger.OperationLogger;
import com.tum.studentmanagement.model.Faculty;
import com.tum.studentmanagement.model.Student;
import com.tum.studentmanagement.model.StudentFacultyPair;
import com.tum.studentmanagement.model.University;
import com.tum.studentmanagement.storage.SaveManager;
import com.tum.studentmanagement.utils.AnsiColor;
import com.tum.studentmanagement.utils.Utils;

/**
 * Application entrypoint for the CLI (compatible with Java 11).
 */
public class Main {
    private static final String DATA_PATH = "data/university.dat";
    private static final String LOG_PATH = "logs/operations.log";

    private final Scanner scanner = new Scanner(System.in);
    private University university;
    private SaveManager saveManager;
    private OperationLogger logger;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try {
            Files.createDirectories(Paths.get("data"));
            Files.createDirectories(Paths.get("logs"));
        } catch (IOException ignored) {}

        saveManager = new SaveManager(DATA_PATH);
        logger = new OperationLogger(LOG_PATH);

        try {
            University loaded = saveManager.load();
            university = (loaded != null) ? loaded : new University();
        } catch (Exception e) {
            System.out.println("Failed to load saved state: " + e.getMessage());
            university = new University();
        }

        System.out.println("Welcome to TUM Student Management (packaged).");
        mainLoop();
    }

    private void mainLoop() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1) General operations");
            System.out.println("2) Faculty operations");
            System.out.println(AnsiColor.green("3) Save now"));
            System.out.println(AnsiColor.yellow("0) Exit"));
            System.out.print(AnsiColor.greenLast("Choose: "));
            String c = scanner.nextLine().trim();
            if ("1".equals(c)) {
                generalMenu();
            } else if ("2".equals(c)) {
                facultyMenu();
            } else if ("3".equals(c)) {
                saveNow();
            } else if ("0".equals(c)) {
                saveNow();
                running = false;
                System.out.println("Saved. Bye.");
            } else {
                System.out.println("Operation is not a valid operation.");
            }
        }
    }

    private void saveNow() {
        try {
            saveManager.save(university);
            System.out.println("Saved.");
        } catch (Exception e) {
            System.out.println("Failed to save: " + e.getMessage());
        }
    }

    // -- General menu --
    private void generalMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- General operations ---");
            System.out.println("1) Create a new faculty");
            System.out.println("2) Search which faculty a student belongs to (by email)");
            System.out.println("3) Display university faculties");
            System.out.println("4) Display all faculties belonging to a field (substring)");
            System.out.println("5) Batch enroll students from CSV file");
            System.out.println("6) Batch graduate students from file");
            System.out.println("0) Back");
            System.out.print(AnsiColor.greenLast("Choose: "));
            String choice = scanner.nextLine().trim();
            if ("1".equals(choice)) {
                createFaculty();
            } else if ("2".equals(choice)) {
                searchStudentFaculty();
            } else if ("3".equals(choice)) {
                listFaculties();
            } else if ("4".equals(choice)) {
                listFacultiesByField();
            } else if ("5".equals(choice)) {
                batchEnroll();
            } else if ("6".equals(choice)) {
                batchGraduate();
            } else if ("0".equals(choice)) {
                back = true;
            } else {
                System.out.println("Operation is not a valid operation.");
            }
        }
    }

    // -- Faculty menu --
    private void facultyMenu() {
        System.out.print(AnsiColor.greenLast("Enter faculty name: "));
        String facultyName = scanner.nextLine().trim();
        Faculty faculty = university.getFaculty(facultyName);
        if (faculty == null) {
            System.out.println("Faculty not found.");
            return;
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- Operations for " + faculty.getName() + " ---");
            System.out.println("1) Create and assign a student to this faculty");
            System.out.println("2) Graduate a student (by email or id)");
            System.out.println("3) Display enrolled students");
            System.out.println("4) Display graduates");
            System.out.println("5) Tell if a student belongs to this faculty (by email)");
            System.out.println("0) Back");
            System.out.print(AnsiColor.greenLast("Choose: "));
            String choice = scanner.nextLine().trim();
            if ("1".equals(choice)) {
                createAndAssignStudent(faculty);
            } else if ("2".equals(choice)) {
                graduateStudent();
            } else if ("3".equals(choice)) {
                displayStudents(faculty.getEnrolledStudents());
            } else if ("4".equals(choice)) {
                displayStudents(faculty.getGraduates());
            } else if ("5".equals(choice)) {
                checkBelongs(faculty);
            } else if ("0".equals(choice)) {
                back = true;
            } else {
                System.out.println("Operation is not a valid operation.");
            }
        }
    }

    // -- Actions implementations --

    private void createFaculty() {
        System.out.print(AnsiColor.greenLast("Faculty name: "));
        String name = scanner.nextLine().trim();
        System.out.print(AnsiColor.greenLast("Field: "));
        String field = scanner.nextLine().trim();
        try {
            university.createFaculty(name, field);
            logger.log("CREATE_FACULTY", name + " (" + field + ")");
            saveNow();
            System.out.println("Created.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchStudentFaculty() {
        System.out.print(AnsiColor.greenLast("Student email: "));
        String email = scanner.nextLine().trim();
        StudentFacultyPair pair = university.findStudentByEmail(email);
        if (pair.student != null) {
            String status = pair.student.isEnrolled() ? "Enrolled" : "Graduated";
            System.out.println("Student " + pair.student.getName() + " (" + pair.student.getEmail() + ") — " + status + " — Faculty: " + pair.faculty.getName());
        } else {
            System.out.println("Student not found.");
        }
    }

    private void listFaculties() {
        List<Faculty> list = university.listFaculties();
        if (list.isEmpty()) {
            System.out.println("No faculties.");
            return;
        }
        for (Faculty f : list) {
            System.out.printf("- %s (%s) — enrolled: %d — grads: %d%n",
                    f.getName(), f.getField(),
                    f.getEnrolledStudents().size(),
                    f.getGraduates().size());
        }
    }

    private void listFacultiesByField() {
        System.out.print("Field substring to match: ");
        String field = scanner.nextLine().trim();
        List<Faculty> found = university.findFacultiesByField(field);
        if (found.isEmpty()) {
            System.out.println("No matching faculties.");
            return;
        }
        for (Faculty f : found) System.out.println("- " + f.getName() + " (" + f.getField() + ")");
    }

    private void batchEnroll() {
        System.out.print(AnsiColor.greenLast("Batch enroll CSV path: "));
        String path = scanner.nextLine().trim();
        try {
            List<String[]> rows = Utils.readBatchEnrollFile(path);
            for (String[] r : rows) {
                try {
                    Student s = university.createAndAssignStudent(r[0], r[1], r[2]);
                    logger.log("BATCH_ENROLL", s.getEmail() + " -> " + r[2]);
                } catch (IllegalArgumentException e) {
                    logger.log("BATCH_ENROLL_ERROR", r[1] + ": " + e.getMessage());
                    System.out.println("Error enrolling " + r[1] + ": " + e.getMessage());
                }
            }
            saveNow();
            System.out.println("Batch enrollment done.");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void batchGraduate() {
        System.out.print(AnsiColor.greenLast("Batch graduate list path: "));
        String path = scanner.nextLine().trim();
        try {
            List<String> ids = Utils.readLines(path);
            for (String id : ids) {
                try {
                    university.graduateStudentByIdentifier(id);
                    logger.log("BATCH_GRADUATE", id);
                } catch (IllegalArgumentException e) {
                    logger.log("BATCH_GRADUATE_ERROR", id + ": " + e.getMessage());
                    System.out.println("Error graduating " + id + ": " + e.getMessage());
                }
            }
            saveNow();
            System.out.println("Batch graduation done.");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void createAndAssignStudent(Faculty faculty) {
        System.out.print(AnsiColor.greenLast("Full name: "));
        String name = scanner.nextLine().trim();
        System.out.print(AnsiColor.greenLast("Email: "));
        String email = scanner.nextLine().trim();
        try {
            Student s = university.createAndAssignStudent(name, email, faculty.getName());
            logger.log("CREATE_STUDENT", s.getEmail() + " -> " + faculty.getName());
            saveNow();
            System.out.println("Student created and assigned.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void graduateStudent() {
        System.out.print(AnsiColor.greenLast("Student email or id to graduate: "));
        String identifier = scanner.nextLine().trim();
        try {
            university.graduateStudentByIdentifier(identifier);
            logger.log("GRADUATE_STUDENT", identifier);
            saveNow();
            System.out.println("Student graduated.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student s : students) System.out.println(s);
    }

    private void checkBelongs(Faculty faculty) {
        System.out.print(AnsiColor.greenLast("Student email: "));
        String email = scanner.nextLine().trim();
        boolean belongs = university.doesStudentBelongToFaculty(email, faculty.getName());
        System.out.println(belongs ? "Belongs." : "Does not belong.");
    }
}