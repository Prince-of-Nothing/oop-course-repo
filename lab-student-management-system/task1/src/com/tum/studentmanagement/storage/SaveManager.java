package com.tum.studentmanagement.storage;

import com.tum.studentmanagement.model.University;

import java.io.*;

/**
 * Simple persistence using Java serialization.
 */
public class SaveManager {
    private final String path;

    public SaveManager(String path) { this.path = path; }

    public void save(University uni) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(uni);
        }
    }

    public University load() throws IOException, ClassNotFoundException {
        File f = new File(path);
        if (!f.exists()) return null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object obj = ois.readObject();
            if (obj instanceof University) return (University) obj;
            throw new IOException("Saved file does not contain a University object.");
        }
    }
}