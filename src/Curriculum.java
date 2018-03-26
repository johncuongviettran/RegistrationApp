import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Curriculum {

    private Map<String, Integer> coursesAndCreditHours;

    public Curriculum (String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Map<String, Integer> tempMap = new LinkedHashMap<>();
        try (Scanner scFile = new Scanner(file)){
            while( scFile.hasNext() ) {
                String tempString = scFile.nextLine();
                String[] tempStringArray = tempString.split(" ");
                tempString = String.join(" ", Arrays.copyOfRange(tempStringArray, 0, tempStringArray.length - 1)).trim();
                int tempInt = Integer.valueOf(tempStringArray[tempStringArray.length-1]);
                tempMap.putIfAbsent(tempString, tempInt);
            }
        }
        this.coursesAndCreditHours = tempMap;
    }

    public Map<String, Integer> getCoursesAndCreditHours() {
        return coursesAndCreditHours;
    }

    public void setCoursesAndCreditHours(Map<String, Integer> coursesAndCreditHours) {
        this.coursesAndCreditHours = coursesAndCreditHours;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "coursesAndCreditHours=" + coursesAndCreditHours +
                '}';
    }

    public String formatCurriculumForOutput (){
        String temp = "  Course                  Credit Hours\n";
        String temp2 = "";
        for (Map.Entry<String,Integer> entry: coursesAndCreditHours.entrySet()) {
            temp2 += entry.getKey() + String.join("", Collections.nCopies(temp.length() - ((String)entry.getKey()).length() - 7, " ")) + entry.getValue() + "\n";
        }
        return temp + temp2;
    }

    public int calculateCreditHoursSum (){
        int sum = 0;
        for (Map.Entry<String,Integer> entry: coursesAndCreditHours.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    public ArrayList<String> findCoursesOfDepartment (String department){
        ArrayList<String> tempList = new ArrayList<>();
        for (Map.Entry<String,Integer> entry: coursesAndCreditHours.entrySet()) {
            if (entry.getKey().startsWith("*")){
                if (entry.getKey().contains("African American Heritage") && department.equals("AADS")){
                    tempList.add(entry.getKey());
                }
                else if (entry.getKey().contains("Human Past") && (department.equals("THEO") || department.equals("PHIL") || department.equals("HIST"))) {
                    tempList.add(entry.getKey());
                }
                else if (entry.getKey().contains("Scientific Reasoning") && (department.equals("BIOL") || department.equals("CHEM") || department.equals("PHYS"))) {
                    tempList.add(entry.getKey());
                }
                else if (entry.getKey().contains("CPSC Elective") && department.equals("CPSC")) {
                    tempList.add(entry.getKey());
                }
            }
            else if (entry.getKey().split(" ")[0].equals(department)){
                tempList.add(entry.getKey());
            }
        }
        return tempList;
    }
    public int getNumberOfCoursesOfDepartment (String department){
        int numberOfCourses = findCoursesOfDepartment(department).size();
        return numberOfCourses;
    }
    public Boolean checkIfContainsCourse (String course, Registrar registrar) {
        ArrayList<CourseRegistrar> viableCourses = new ArrayList<>();
        viableCourses.addAll(registrar.getRegistrar());
        Boolean bool = null;
        if (coursesAndCreditHours.containsKey(course)) {
            bool = Boolean.TRUE;
        }
        else if ((coursesAndCreditHours.containsKey("* African American Heritage") || coursesAndCreditHours.containsKey("* Human Past")
                || coursesAndCreditHours.containsKey("* Scientific Reasoning") || coursesAndCreditHours.containsKey("* CPSC Elective"))
                && (course.contains("AADS") || course.contains("HIST") || course.contains("PHIL") || course.contains("THEO")
                || course.contains("BIOL") || course.contains("CHEM") || course.contains("PHYS") || course.contains("CPSC"))){
            for (CourseRegistrar courses :viableCourses) {
                if (course.equals(courses.getCourse())){
                    bool = Boolean.TRUE;
                    break;
                }
                else {
                    bool = Boolean.FALSE;
                }
            }
        }
        else {
            bool = Boolean.FALSE;
        }
        return bool;
    }
    public Boolean checkIfContainsCourse (String course){
        if (coursesAndCreditHours.containsKey(course)){
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
