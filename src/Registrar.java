import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

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
    public ArrayList<CourseRegistrar> getRegistrar() {
        return registrar;
    }
}
