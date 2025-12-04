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

    private static final boolean enabled = detect();

    private static boolean detect() {
        // Honor explicit overrides
        if (System.getenv("NO_COLOR") != null) return false;
        if (System.getenv("FORCE_COLOR") != null) return true;

        String os = System.getProperty("os.name", "").toLowerCase();
        // Non-windows usually support ANSI
        if (!os.contains("win")) return true;

        // On Windows, check for known terminals that support ANSI:
        // - ANSICON (legacy)
        // - ConEmu (ConEmuANSI=ON)
        // - Windows Terminal (WT_SESSION)
        // - TERM_PROGRAM (e.g. "vscode")
        // - TERM contains "xterm"
        String ansicon = System.getenv("ANSICON");
        if (ansicon != null && !ansicon.isEmpty()) return true;
        String conEmu = System.getenv("ConEmuANSI");
        if ("ON".equalsIgnoreCase(conEmu)) return true;
        if (System.getenv("WT_SESSION") != null) return true;
        String termProgram = System.getenv("TERM_PROGRAM");
        if (termProgram != null && !termProgram.isEmpty()) return true;
        String term = System.getenv("TERM");
        if (term != null && term.toLowerCase().contains("xterm")) return true;

        // fallback: try to detect if running in typical consoles where ANSI is not available
        return false;
    }

    public static String color(String text, Color c) {
        if (!enabled) return text;
        return c.code() + text + RESET;
    }

    // --- New helper: color the last token/element of text ---
    public static String colorLast(String text, Color c) {
        if (text == null || text.isEmpty()) return text;
        // preserve trailing whitespace
        int end = text.length() - 1;
        while (end >= 0 && Character.isWhitespace(text.charAt(end))) end--;
        if (end < 0) return text; // all whitespace

        int start = end;
        while (start >= 0 && !Character.isWhitespace(text.charAt(start))) start--;
        String prefix = text.substring(0, start + 1);
        String last = text.substring(start + 1, end + 1);
        String suffix = text.substring(end + 1); // trailing whitespace preserved
        return prefix + color(last, c) + suffix;
    }

    public static String red(String text) { return color(text, Color.RED); }
    public static String green(String text) { return color(text, Color.GREEN); }
    public static String yellow(String text) { return color(text, Color.YELLOW); }
    public static String blue(String text) { return color(text, Color.BLUE); }

    // convenience: color last token green
    public static String greenLast(String text) { return colorLast(text, Color.GREEN); }
}