import java.time.LocalTime;

public class CourseRegistrar {

    private Department department;
    private Integer courseNumber;
    private Integer sectionNumber;
    private LocalTime startTime;
    private Integer lengthOfCourseInMinutes;

    public CourseRegistrar(Department department, Integer courseNumber, Integer sectionNumber, LocalTime startTime, Integer lengthOfCourseInMinutes) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.sectionNumber = sectionNumber;
        this.startTime = startTime;
        this.lengthOfCourseInMinutes = lengthOfCourseInMinutes;
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
    public Integer getLengthOfCourseInMinutes() {
        return lengthOfCourseInMinutes;
    }
    public String getCourse(){
        return department + " " + courseNumber;
    }
    public String getCourseAndSection(){
        return department + " " + courseNumber + " " + sectionNumber;
    }
}

