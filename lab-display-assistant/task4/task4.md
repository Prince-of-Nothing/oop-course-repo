# Task 4: Bonus Task – Multiple Text Files Analysis

## Overview:
This task expands on Task 2. Instead of analyzing just one file, the program should be able to process multiple text files passed via command-line arguments. Each file is analyzed separately, and the results are displayed individually.

### Goals:

Extend your existing program to handle multiple files.

Reuse the TextData and FileReader classes from Task 2.

Practice iterating through arrays of arguments and managing multiple objects.

### Main Class:

Accepts one or more file paths as arguments.

For each file path, reads the file content using FileReader.readFileIntoString().

Creates a TextData object for each file.

### Results:
- File Name
- Number of Vowels
- Number of Consonants
- Total Letters
- Number of Sentences
- Longest Word

### Sample Output:
----- Text Data Analysis -----
File Name       : c:\Users\Unknown\Documents\GitHub\oop-course-repo\lab-display-assistant\task4\src\Seo.txt
Vowels          : 24
Consonants      : 35
Total Letters   : 59
Sentences       : 1
Longest Word    : morning
------------------------------
