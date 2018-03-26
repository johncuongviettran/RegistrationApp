import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Transcript {

    private ArrayList<CourseTranscript> transcript;

    public Transcript(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        ArrayList<CourseTranscript> tempList = new ArrayList<>();
        try (Scanner scFile = new Scanner(file)){
            while( scFile.hasNext() ) {
                String department = scFile.next();
                Integer courseNumber = Integer.valueOf(scFile.next());
                Integer creditHours = Integer.valueOf(scFile.next());
                CourseTranscript course = new CourseTranscript(Department.valueOf(department), courseNumber, creditHours);
                tempList.add(course);
            }
        }
        this.transcript = tempList;
    }
    public String formatForOutput (){
        String temp = "Course   Credit Hours\n";
        for (CourseTranscript course: transcript) {
            temp += course.getDepartment() + " " + course.getCourseNumber() + "     " + course.getCreditHours() + "\n";
        }
        return temp;
    }
    public int calculateCreditHoursSum (){
        int sum = 0;
        for (CourseTranscript course: transcript) {
            sum += course.getCreditHours();
        }
        return sum;
    }

    public ArrayList<CourseTranscript> getTranscript() {
        return transcript;
    }
    public Map<String, Boolean> checkIfTranscriptCourseInCurriculum(Curriculum curriculum, Registrar registrar){
        Map<String, Boolean> tempMap = new LinkedHashMap<>();
        for (CourseTranscript course: transcript) {
            if (curriculum.checkIfContainsCourse(course.getCourse(), registrar)){
                tempMap.putIfAbsent(course.getCourseAndCreditHours(), Boolean.TRUE);
            }
            else {
                tempMap.putIfAbsent(course.getCourseAndCreditHours(), Boolean.FALSE);
            }
        }
        return tempMap;
    }
    public Boolean checkIfContainsCourse (Department department, Integer courseNumber, Integer creditHours){
        CourseTranscript tempCourse = new CourseTranscript(department,courseNumber,creditHours);
        if (transcript.contains(tempCourse)){
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
    public Boolean checkIfContainsCourse (CourseTranscript course){
        if (transcript.contains(course)){
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
    public Boolean checkIfAllCurriculumRequirementsAreCompleted (Curriculum curriculum, Registrar registrar){
        Integer count = 0;
        Map<String, Boolean> tempMap = checkIfTranscriptCourseInCurriculum(curriculum,registrar);
        for (Map.Entry<String, Boolean> entry: tempMap.entrySet()) {
            if (entry.getValue().equals(Boolean.TRUE)){
                count++;
            }
        }
        if (count.equals(curriculum.getCoursesAndCreditHours().size())){
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
