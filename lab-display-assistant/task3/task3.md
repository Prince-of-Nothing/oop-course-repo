# Task 3: Class Composition - Assistant Class

## Overview:
In this task, you create an Assistant class that manages Display objects. The Assistant helps the user choose the right display by providing detailed information about all monitors assigned to it.

### Goals:

Understand and practice class composition.

Work with lists and iterate through objects.

Reuse the Display class from Task 1.

Assistant Class:

### Attributes:

`assistantName (String)`: The name of the assistant.

`assignedDisplays (List of Display objects)`: List of Display objects assigned to the assistant.

### Methods:

`assignDisplay(Display d)`: Adds a Display object to the assignedDisplays list.

`assist()`: Iterates through assignedDisplays, compares each display sequentially, and prints descriptive output about size, sharpness, or both.

`buyDisplay(Display d)`: Removes the specified Display from the list and returns it.
