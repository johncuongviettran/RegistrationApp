import java.time.LocalTime;

public class Course {

    private Department department;
    private Integer courseNumber;
    private Integer sectionNumber;
    private LocalTime startTime;

    public Course(Department department, Integer courseNumber, Integer sectionNumber, LocalTime startTime) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.sectionNumber = sectionNumber;
        this.startTime = startTime;
    }

    public Department getDepartment() {
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

