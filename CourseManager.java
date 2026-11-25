import java.util.ArrayList;

/**
 * CourseManager.java
 * Holds the ArrayList of courses and implements CRUD, searching and sorting.
 *
 * DSA concepts used:
 *  - ArrayList          : storage of courses
 *  - Linear Search      : by name / instructor (partial, case-insensitive)
 *  - Binary Search      : by course ID (list is sorted by ID first)
 *  - Bubble Sort        : sort by ID
 *  - Selection Sort     : sort by credits
 *  - Insertion Sort     : sort by name
 */
public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();

    // ---------------- CRUD ----------------

    public boolean addCourse(Course c) {
        if (findIndexById(c.getId()) != -1) return false; // duplicate ID
        courses.add(c);
        return true;
    }

    public boolean removeCourse(int id) {
        int idx = findIndexById(id);
        if (idx == -1) return false;
        courses.remove(idx);
        return true;
    }

    public boolean updateCourse(int id, String name, String instructor, int credits) {
        int idx = findIndexById(id);
        if (idx == -1) return false;
        Course c = courses.get(idx);
        c.setName(name);
        c.setInstructor(instructor);
        c.setCredits(credits);
        return true;
    }

    public void displayAll() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        printHeader();
        for (Course c : courses) System.out.println(c);
    }

    public int size() { return courses.size(); }

    private void printHeader() {
        System.out.println(String.format("%-6s %-30s %-22s %-7s", "ID", "Course Name", "Instructor", "Credits"));
        System.out.println("-".repeat(68));
    }

    // ---------------- SEARCHING ----------------

    /** Linear search by ID (works on unsorted list). Returns index or -1. */
    public int findIndexById(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) return i;
        }
        return -1;
    }

    /** Linear search by course name (partial match, case-insensitive). */
    public void searchByName(String keyword) {
        ArrayList<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getName().toLowerCase().contains(keyword.toLowerCase())) result.add(c);
        }
        printResults(result);
    }

    /** Linear search by instructor (partial match, case-insensitive). */
    public void searchByInstructor(String keyword) {
        ArrayList<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getInstructor().toLowerCase().contains(keyword.toLowerCase())) result.add(c);
        }
        printResults(result);
    }

    /** Binary search by ID. Sorts the list by ID first (required for binary search). */
    public void binarySearchById(int id) {
        bubbleSortById();
        int low = 0, high = courses.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = courses.get(mid).getId();
            if (midId == id) {
                ArrayList<Course> result = new ArrayList<>();
                result.add(courses.get(mid));
                printResults(result);
                return;
            } else if (midId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Course with ID " + id + " not found.");
    }

    private void printResults(ArrayList<Course> list) {
        if (list.isEmpty()) {
            System.out.println("No matching courses found.");
            return;
        }
        printHeader();
        for (Course c : list) System.out.println(c);
    }

    // ---------------- SORTING ----------------

    /** Bubble sort by ID (ascending). */
    public void bubbleSortById() {
        int n = courses.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (courses.get(j).getId() > courses.get(j + 1).getId()) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    /** Selection sort by credits (ascending). */
    public void selectionSortByCredits() {
        int n = courses.size();
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (courses.get(j).getCredits() < courses.get(min).getCredits()) min = j;
            }
            if (min != i) swap(i, min);
        }
    }

    /** Insertion sort by name (A-Z, case-insensitive). */
    public void insertionSortByName() {
        for (int i = 1; i < courses.size(); i++) {
            Course key = courses.get(i);
            int j = i - 1;
            while (j >= 0 && courses.get(j).getName().compareToIgnoreCase(key.getName()) > 0) {
                courses.set(j + 1, courses.get(j));
                j--;
            }
            courses.set(j + 1, key);
        }
    }

    private void swap(int i, int j) {
        Course temp = courses.get(i);
        courses.set(i, courses.get(j));
        courses.set(j, temp);
    }
}