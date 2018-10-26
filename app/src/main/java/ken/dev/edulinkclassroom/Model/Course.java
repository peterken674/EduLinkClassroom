package ken.dev.edulinkclassroom.Model;

public class Course {
    private String title, department, description;
    private CourseUnit units[] = new CourseUnit[64];
    private int currentYear;

    public Course(String title, String department, String description) {
        this.title = title;
        this.department = department;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    @Override
    public String toString(){
        return title;
    }
}
