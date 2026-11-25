import java.util.Scanner;

/**
 * Main.java
 * Console menu for the Course List Management System.
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static CourseManager manager = new CourseManager();

    public static void main(String[] args) {
        // Sample data so the program is not empty on first run
        manager.addCourse(new Course(103, "Data Structures", "Dr. Sharma", 4));
        manager.addCourse(new Course(101, "Java Programming", "Prof. Verma", 3));
        manager.addCourse(new Course(105, "Operating Systems", "Dr. Khan", 4));
        manager.addCourse(new Course(102, "Database Systems", "Prof. Mehta", 3));
        manager.addCourse(new Course(104, "Computer Networks", "Dr. Iyer", 2));

        int choice;
        do {
            printMenu();
            choice = readInt("Enter choice: ");
            switch (choice) {
                case 1: addCourse(); break;
                case 2: removeCourse(); break;
                case 3: updateCourse(); break;
                case 4: manager.displayAll(); break;
                case 5: manager.searchByName(readLine("Enter course name keyword: ")); break;
                case 6: manager.searchByInstructor(readLine("Enter instructor keyword: ")); break;
                case 7: manager.binarySearchById(readInt("Enter course ID: ")); break;
                case 8: manager.bubbleSortById(); System.out.println("Sorted by ID."); manager.displayAll(); break;
                case 9: manager.insertionSortByName(); System.out.println("Sorted by Name."); manager.displayAll(); break;
                case 10: manager.selectionSortByCredits(); System.out.println("Sorted by Credits."); manager.displayAll(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    static void printMenu() {
        System.out.println("\n===== COURSE LIST MANAGEMENT SYSTEM =====");
        System.out.println(" 1. Add Course");
        System.out.println(" 2. Remove Course");
        System.out.println(" 3. Update Course");
        System.out.println(" 4. Display All Courses");
        System.out.println(" 5. Search by Name (Linear Search)");
        System.out.println(" 6. Search by Instructor (Linear Search)");
        System.out.println(" 7. Search by ID (Binary Search)");
        System.out.println(" 8. Sort by ID (Bubble Sort)");
        System.out.println(" 9. Sort by Name (Insertion Sort)");
        System.out.println("10. Sort by Credits (Selection Sort)");
        System.out.println(" 0. Exit");
    }

    static void addCourse() {
        int id = readInt("Course ID: ");
        String name = readLine("Course Name: ");
        String instructor = readLine("Instructor: ");
        int credits = readInt("Credits: ");
        if (manager.addCourse(new Course(id, name, instructor, credits)))
            System.out.println("Course added.");
        else
            System.out.println("A course with this ID already exists.");
    }

    static void removeCourse() {
        int id = readInt("Course ID to remove: ");
        System.out.println(manager.removeCourse(id) ? "Course removed." : "Course not found.");
    }

    static void updateCourse() {
        int id = readInt("Course ID to update: ");
        if (manager.findIndexById(id) == -1) {
            System.out.println("Course not found.");
            return;
        }
        String name = readLine("New Name: ");
        String instructor = readLine("New Instructor: ");
        int credits = readInt("New Credits: ");
        manager.updateCourse(id, name, instructor, credits);
        System.out.println("Course updated.");
    }

    static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}