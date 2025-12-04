package task1;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate enrollmentDate;
    private LocalDate dateOfBirth;
    private boolean graduated;

    // Constructor
    public Student(String firstName, String lastName, String email, LocalDate enrollmentDate, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
        this.graduated = false;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public boolean isGraduated() { return graduated; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setGraduated(boolean graduated) { this.graduated = graduated; }

    // Additional functionality
    public void graduate() { this.graduated = true; }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + ") "
                + (graduated ? "[GRADUATED]" : "[ENROLLED]");
    }
}
