import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.*;

public class Registrar {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<CourseRegistrar> registrar;

    public Registrar(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        ArrayList<CourseRegistrar> tempList = new ArrayList<>();
        try (Scanner scFile = new Scanner(file)){
            while( scFile.hasNext() ) {
                String department = scFile.next();
                Integer courseNumber = Integer.valueOf(scFile.next());
                Integer sectionNumber = Integer.valueOf(scFile.next());
                String[] tempArray = scFile.next().split(":");
                LocalTime startTime = LocalTime.of(Integer.valueOf(tempArray[0]), Integer.valueOf(tempArray[1]));
                System.out.println("Enter the length of course, " + department + " " + courseNumber + " " + sectionNumber + ", in minutes:");
                Integer lengthOfCourseInMinutes = sc.nextInt();
                CourseRegistrar course = new CourseRegistrar(Department.valueOf(department),courseNumber,sectionNumber,startTime, lengthOfCourseInMinutes);
                tempList.add(course);
            }
        }
        this.registrar = tempList;
    }
    public Registrar(String fileName, Integer lengthOfAllCoursesInMinutes) throws FileNotFoundException {
        File file = new File(fileName);
        ArrayList<CourseRegistrar> tempList = new ArrayList<>();
        try (Scanner scFile = new Scanner(file)){
            while( scFile.hasNext() ) {
                String department = scFile.next();
                Integer courseNumber = Integer.valueOf(scFile.next());
                Integer sectionNumber = Integer.valueOf(scFile.next());
                String[] tempArray = scFile.next().split(":");
                LocalTime startTime = LocalTime.of(Integer.valueOf(tempArray[0]), Integer.valueOf(tempArray[1]));
                CourseRegistrar course = new CourseRegistrar(Department.valueOf(department),courseNumber,sectionNumber,startTime, lengthOfAllCoursesInMinutes);
                tempList.add(course);
            }
        }
        this.registrar = tempList;
    }

    public Registrar(ArrayList<CourseRegistrar> registrar) {
        this.registrar = registrar;
    }

    public ArrayList<CourseRegistrar> getRegistrar() {
        return registrar;
    }
    public String formatForOutput (){
        String temp = "Department/Course Number/Section Number/Start Time/Course Length(Minutes)\n";
        for (CourseRegistrar course: registrar) {
            temp += course.formatForOutput() + "\n";
        }
        return temp;
    }
    public Registrar findCoursesOfSpecifcDepartment (Department department){
        ArrayList<CourseRegistrar> tempList = new ArrayList<>();
        for (CourseRegistrar course: registrar) {
            if (course.getDepartment().equals(department)){
                tempList.add(course);
            }
        }
        Registrar tempRegistrar = new Registrar(tempList);
        return tempRegistrar;
    }
    public Registrar findCoursesOfSpecifcDepartment (String department){
        ArrayList<CourseRegistrar> tempList = new ArrayList<>();
        Department target = Department.valueOf(department);
        for (CourseRegistrar course: registrar) {
            if (course.getDepartment().equals(target)){
                tempList.add(course);
            }
        }
        Registrar tempRegistrar = new Registrar(tempList);
        return tempRegistrar;
    }
    public Registrar findCoursesWithinTimeFrame (LocalTime startTime, LocalTime endTime){
        ArrayList<CourseRegistrar> tempList = new ArrayList<>();
        for (CourseRegistrar course: registrar) {
            LocalTime tempStartTime = course.getStartTime();
            LocalTime tempEndTime = tempStartTime.plusMinutes(course.getLengthOfCourseInMinutes());
            if (tempStartTime.compareTo(startTime) >= 0 && tempStartTime.compareTo(endTime) < 0 && tempEndTime.compareTo(endTime) <= 0 ){
                tempList.add(course);
            }
        }
        Registrar tempRegistrar = new Registrar(tempList);
        return tempRegistrar;
    }
    public Registrar findCoursesWithinTimeFrame (int startTimeHour, int startTimeMinute, int endTimeHour, int endTimeMinute){
        ArrayList<CourseRegistrar> tempList = new ArrayList<>();
        LocalTime startTime = LocalTime.of(startTimeHour,startTimeMinute);
        LocalTime endTime = LocalTime.of(endTimeHour,endTimeMinute);
        for (CourseRegistrar course: registrar) {
            LocalTime tempStartTime = course.getStartTime();
            LocalTime tempEndTime = tempStartTime.plusMinutes(course.getLengthOfCourseInMinutes());
            if (tempStartTime.compareTo(startTime) >= 0 && tempStartTime.compareTo(endTime) < 0 && tempEndTime.compareTo(endTime) <= 0 ){
                tempList.add(course);
            }
        }
        Registrar tempRegistrar = new Registrar(tempList);
        return tempRegistrar;
    }
    public Set<CourseRegistrar> findCoursesForCategory (String category, Curriculum curriculum){
        Set<CourseRegistrar> tempSet = new HashSet<>();
        for (CourseRegistrar course:registrar) {
            if (category.contains("African American Heritage") && course.getDepartment().equals(Department.AADS) && !curriculum.getCoursesAndCreditHours().containsKey(course.getCourse())){
                tempSet.add(course);
            }
            else if (category.contains("Human Past") && (course.getDepartment().equals(Department.THEO) || course.getDepartment().equals(Department.PHIL) || course.getDepartment().equals(Department.HIST)) && !curriculum.getCoursesAndCreditHours().containsKey(course.getCourse())) {
                tempSet.add(course);;
            }
            else if (category.contains("Scientific Reasoning") && (course.getDepartment().equals(Department.BIOL) || course.getDepartment().equals(Department.CHEM) || course.getDepartment().equals(Department.PHYS)) && !curriculum.getCoursesAndCreditHours().containsKey(course.getCourse())) {
                tempSet.add(course);;
            }
            else if (category.contains("CPSC Elective") && course.getDepartment().equals(Department.CPSC) && !curriculum.getCoursesAndCreditHours().containsKey(course.getCourse())) {
                tempSet.add(course);;
            }
        }
        return tempSet;
    }
    public Boolean checkIfContainsCourse (Department department, Integer courseNumber, Integer sectionNumber, LocalTime startTime, Integer lengthOfCourseInMinutes){
        CourseRegistrar tempCourse = new CourseRegistrar(department,courseNumber,sectionNumber,startTime,lengthOfCourseInMinutes);
        if (registrar.contains(tempCourse)){
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
    public Boolean checkIfContainsCourse (CourseRegistrar course){
        if (registrar.contains(course)){
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
