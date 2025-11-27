# Laboratory Work: Task 2 – Program Arguments and Text Parsing
**Year:** 2025
**Course:** FAF.OOP24.1
**Lab:** #4.1 ->
**Task #** 2


---

## Task 2 Overview

**Goal:**

* Learn class reuse (existing or new).
* Learn to pass command line arguments to a program.
* Practice text parsing through a fun challenge.

**Description:**

* Use the `String[] args` in the `main` method to get the **name** and **location** of a `.txt` file.
* Reuse or create a `FileReader` class to read file content.

---

## TextData Class

The `TextData` class represents the processed text file.

### Attributes

| Attribute          | Type   | Description                      |
| ------------------ | ------ | -------------------------------- |
| fileName           | String | Name of the file                 |
| text               | String | Contents of the file             |
| numberOfVowels     | int    | Count of vowels in the text      |
| numberOfConsonants | int    | Count of consonants in the text  |
| numberOfLetters    | int    | Count of all letters in the text |
| numberOfSentences  | int    | Count of sentences in the text   |
| longestWord        | String | Longest word found in the text   |

### Methods

| Method                  | Return Type | Description                        |
| ----------------------- | ----------- | ---------------------------------- |
| TextData(String text)   | Constructor | Initialize object and process text |
| getFileName()           | String      | Returns file name                  |
| getText()               | String      | Returns the raw text               |
| getNumberOfVowels()     | int         | Returns number of vowels           |
| getNumberOfConsonants() | int         | Returns number of consonants       |
| getNumberOfLetters()    | int         | Returns total letters              |
| getNumberOfSentences()  | int         | Returns sentence count             |
| getLongestWord()        | String      | Returns the longest word           |

---

## Notes

* Handles Romanian diacritics (`ă`, `â`, `î`, `ș`, `ț`) correctly.
* Uses `Character.isLetter()` for counting letters.
* Splits words with `[^\\p{L}]+` to correctly include all Unicode letters.
* Can be extended to handle multiple files via command-line arguments.
