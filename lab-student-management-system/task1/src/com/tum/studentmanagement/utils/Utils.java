package com.tum.studentmanagement.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class Utils {
    private Utils() {}

    private static final String EMAIL_RE = "[^@]+@[^@]+\\.[^@]+";

    public static boolean validateEmail(String email) {
        if (email == null) return false;
        return email.trim().matches(EMAIL_RE);
    }

    public static List<String[]> readBatchEnrollFile(String path) throws IOException {
        List<String> lines = readLines(path);
        List<String[]> out = new ArrayList<>();
        for (String line : lines) {
            if (line.trim().isEmpty() || line.trim().startsWith("#")) continue;
            String[] parts = line.split(",", -1);
            if (parts.length < 3) throw new IOException("Invalid CSV row: " + line);
            out.add(new String[] { parts[0].trim(), parts[1].trim(), parts[2].trim() });
        }
        return out;
    }

    public static List<String> readLines(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }
}