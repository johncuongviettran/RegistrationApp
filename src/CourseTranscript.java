public class CourseTranscript {

    private Department department;
    private Integer courseNumber;
    private Integer creditHours;

    public CourseTranscript(Department department, Integer courseNumber, Integer creditHours) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.creditHours = creditHours;
    }

    public Department getDepartment() {
        return department;
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public Integer getCreditHours() {
        return creditHours;
    }
    public String getCourse(){
        return department + " " + courseNumber;
    }
    public String getCourseAndCreditHours(){
        return department + " " + courseNumber  + " " + creditHours;
    }
}
