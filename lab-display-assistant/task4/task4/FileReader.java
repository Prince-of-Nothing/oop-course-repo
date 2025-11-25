package task4;

import java.io.IOException;//In case file handling fails
import java.nio.file.Files;//Provides static methods to work with files
import java.nio.file.Paths;//converts a * string path into a Path object

public class FileReader {
    public static String readFileIntoString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}