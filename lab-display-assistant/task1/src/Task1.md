# Task 1: Objects & Object Interaction

## Overview

In this task, the goal is to get familiar with **classes, objects, and object interaction** in Java.
We create a `Display` class and instantiate multiple objects to compare their attributes like size and sharpness.

---

## Class: `Display`

### Attributes

| Attribute | Type   | Description                     |
| --------- | ------ | ------------------------------- |
| width     | int    | Width of the display in pixels  |
| height    | int    | Height of the display in pixels |
| ppi       | float  | Pixel density of the display    |
| model     | String | Display model name              |

### Methods

| Method                        | Description                                                                        |
| ----------------------------- | ---------------------------------------------------------------------------------- |
| compareSize(Display m)        | Compares this display’s size to another display and prints a descriptive result    |
| compareSharpness(Display m)   | Compares this display’s sharpness (ppi) with another display and prints the result |
| compareWithMonitor(Display m) | Compares both size and sharpness of this display with another display              |

---

## Instructions

1. **Create the Display class** with the attributes and methods above.
2. **Instantiate 3 Display objects** in your `main` method, giving each object different attribute values.
3. **Use the methods to compare objects**, printing descriptive messages for each comparison. The output should be **verbose**, indicating which display is bigger, sharper, or superior overall.

---

## Learning Goals

* Understand how to **design and implement a class** in Java.
* Learn how to **instantiate multiple objects** from the same class.
* Practice **object interaction** through methods that take other objects as parameters.
* Reinforce **code reuse** and modular programming principles.
* Gain experience with **verbose, descriptive outputs** for comparisons.

---

## Notes

* Each task should be in its own **package/module**.
* All methods are **inside the class** and are correctly called as **methods**, not functions.
* Keep outputs clear and user-friendly to demonstrate comparisons effectively.
