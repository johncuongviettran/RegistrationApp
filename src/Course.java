import java.time.LocalTime;

public class Course {

    String department;
    Integer courseNumber;
    Integer sectionNumber;
    LocalTime startTime;

    public Course(String department, Integer courseNumber, Integer sectionNumber, LocalTime startTime) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.sectionNumber = sectionNumber;
        this.startTime = startTime;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public Integer getSectionNumber() {
        return sectionNumber;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
}

