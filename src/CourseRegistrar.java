import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CourseRegistrar {

    private DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");

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
    public String formatForOutput (){
        return department + " " + courseNumber + " " + sectionNumber + " " + startTime.format(format) + " " + lengthOfCourseInMinutes;
    }

    @Override
    public boolean equals(Object obj) {
    CourseRegistrar other = (CourseRegistrar)obj;
        if (this.department.equals(other.department) && this.courseNumber.equals(other.courseNumber) && this.sectionNumber.equals(other.sectionNumber)){
            return true;
        }
        else {
            return false;
        }
    }
}

