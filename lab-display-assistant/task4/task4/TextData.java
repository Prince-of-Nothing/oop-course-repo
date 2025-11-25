package task4;

public class TextData {
    //The private attributes
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        this.numberOfVowels = countVowels(text);
        this.numberOfConsonants = countConsonants(text);
        this.numberOfLetters = countLetters(text);
        this.numberOfSentences = countSentences(text);
        this.longestWord = findLongestWord(text);
    }

    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }


    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }


    private int countVowels(String text) {
        int count = 0;
        for (char letter : text.toLowerCase().toCharArray()) {
            if ("aeiouăâî".indexOf(letter) != -1) {
                count++;
            }
        }
        return count;
    }

    private int countConsonants(String text) {
        int count = 0;
        for (char letter : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(letter) && "aeiouăâî".indexOf(letter) == -1) {
                count++;
            }
        }
        return count;
    }

    private int countLetters(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }

    private int countSentences(String text) {
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

    private String findLongestWord(String text) {
        String[] words = text.split("[^\\p{L}]+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
}