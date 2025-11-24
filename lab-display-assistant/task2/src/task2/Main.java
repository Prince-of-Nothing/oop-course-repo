package task2;

import java.io.IOException;//In case if file handling fails

public class Main {
    public static void main(String[] args) {
        // Check if any file paths are provided
        if (args.length < 1) {
            System.out.println("Please provide at least one file path as a command-line argument.");
            return;
        }

        // Loop through each file path provided in the arguments
        for (String filePath : args) {
            try {
                String content = FileReader.readFileIntoString(filePath);
            TextData textData = new TextData(filePath, content);
              System.out.println("----- Text Data Analysis -----");
        System.out.println("File Name       : " + textData.getFileName());
      
        System.out.println("Vowels          : " + textData.getNumberOfVowels());
      
        System.out.println("Consonants      : " + textData.getNumberOfConsonants());
        System.out.println("Total Letters   : " + textData.getNumberOfLetters());
        System.out.println("Sentences       : " + textData.getNumberOfSentences());
        //It is the first longest word found in the text
        System.out.println("Longest Word    : " + textData.getLongestWord());
        System.out.println("------------------------------");
            } catch (IOException e) {
                System.err.println("Error reading file '" + filePath + "': " + e.getMessage());
            }
        }
    }
}