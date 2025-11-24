package task2;

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

}