/**
 * Course.java
 * Model class representing a single course.
 */
public class Course {
    private int id;
    private String name;
    private String instructor;
    private int credits;

    public Course(int id, String name, String instructor, int credits) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getInstructor() { return instructor; }
    public int getCredits() { return credits; }

    public void setName(String name) { this.name = name; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setCredits(int credits) { this.credits = credits; }

    @Override
    public String toString() {
        return String.format("%-6d %-30s %-22s %-7d", id, name, instructor, credits);
    }
}