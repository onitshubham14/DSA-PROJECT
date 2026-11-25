# Course List Management System

A console-based Java application to manage a university course list. Built as a Data Structures & Algorithms (DSA) project to demonstrate **ArrayList**, **searching** and **sorting**.

## Features

- Add, remove, update and display courses
- Search by course name or instructor (partial, case-insensitive)
- Search by course ID using binary search
- Sort courses by ID, name or credits
- Duplicate course ID protection and input validation

## DSA Concepts Used

| Concept | Where it is used | Time Complexity |
|---|---|---|
| ArrayList | Stores all `Course` objects | Access O(1), Add O(1) amortized, Remove O(n) |
| Linear Search | Search by name / instructor / ID check | O(n) |
| Binary Search | Search by course ID (list sorted first) | O(log n) |
| Bubble Sort | Sort by ID | O(n²) worst, O(n) best |
| Selection Sort | Sort by credits | O(n²) |
| Insertion Sort | Sort by name (A-Z) | O(n²) worst, O(n) best |

> The sorting algorithms are implemented manually instead of using `Collections.sort()` to show how they work.

## Project Structure

```
.
├── Course.java          # Model class (id, name, instructor, credits)
├── CourseManager.java   # ArrayList storage, CRUD, searching, sorting
├── Main.java            # Console menu / entry point
└── README.md
```

## How to Run

**Requirements:** Java JDK 8 or higher

```bash
javac *.java
java Main
```

## Menu Options

```
===== COURSE LIST MANAGEMENT SYSTEM =====
 1. Add Course
 2. Remove Course
 3. Update Course
 4. Display All Courses
 5. Search by Name (Linear Search)
 6. Search by Instructor (Linear Search)
 7. Search by ID (Binary Search)
 8. Sort by ID (Bubble Sort)
 9. Sort by Name (Insertion Sort)
10. Sort by Credits (Selection Sort)
 0. Exit
```

## Sample Output

```
ID     Course Name                    Instructor             Credits
--------------------------------------------------------------------
104    Computer Networks              Dr. Iyer               2
102    Database Systems               Prof. Mehta            3
101    Java Programming               Prof. Verma            3
103    Data Structures                Dr. Sharma             4
105    Operating Systems              Dr. Khan               4
```

## How It Works

- **Binary search** needs sorted data, so `binarySearchById()` first sorts the list by ID with bubble sort, then repeatedly halves the search range.
- **Insertion sort** compares names with `compareToIgnoreCase()`, so "algorithms" and "Algorithms" are ordered correctly.
- **Duplicate IDs** are rejected when adding a course.

## Possible Future Improvements

- Save and load courses from a file
- Merge sort / quick sort for better performance
- GUI using Java Swing or JavaFX
- Additional fields such as semester, department and prerequisites

## Author

Your Name – Your University, Your Course / Year
