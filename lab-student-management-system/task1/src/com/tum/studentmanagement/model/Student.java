package com.tum.studentmanagement.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String name;
    private final String email;
    private boolean enrolled;

    public Student(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = Objects.requireNonNull(name).trim();
        this.email = Objects.requireNonNull(email).trim().toLowerCase();
        this.enrolled = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public boolean isEnrolled() { return enrolled; }
    public void setEnrolled(boolean e) { this.enrolled = e; }

    @Override
    public String toString() {
        return String.format("%s | %s | %s", id, name, email) + (enrolled ? " [ENROLLED]" : " [GRADUATED]");
    }
}