package com.tum.studentmanagement.utils;

/**
 * Small ANSI color helper. Detects basic ANSI support heuristically; you can force enable/disable.
 */
public final class AnsiColor {
    private AnsiColor() {}

    public static final String RESET = "\u001B[0m";
    public enum Color {
        RED("\u001B[31m"), GREEN("\u001B[32m"), YELLOW("\u001B[33m"), BLUE("\u001B[34m");
        private final String code;
        Color(String code) { this.code = code; }
        public String code() { return code; }
    }

    private static boolean enabled = detect();

    private static boolean detect() {
        String os = System.getProperty("os.name", "").toLowerCase();
        if (!os.contains("win")) return true;
        String term = System.getenv("TERM");
        if (term != null && term.toLowerCase().contains("xterm")) return true;
        return false;
    }

    public static String color(String text, Color c) {
        if (!enabled) return text;
        return c.code() + text + RESET;
    }

    public static String red(String text) { return color(text, Color.RED); }
    public static String green(String text) { return color(text, Color.GREEN); }
    public static String yellow(String text) { return color(text, Color.YELLOW); }
    public static String blue(String text) { return color(text, Color.BLUE); }
}