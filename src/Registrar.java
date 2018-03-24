import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Registrar {

    private ArrayList<Course> registrar;

    public Registrar(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        ArrayList<Course> tempList = new ArrayList<>();
        try (Scanner scFile = new Scanner(file)){
            while( scFile.hasNext() ) {
                String department = scFile.next();
                Integer courseNumber = Integer.valueOf(scFile.next());
                Integer sectionNumber = Integer.valueOf(scFile.next());
                String[] tempArray = scFile.next().split(":");
                LocalTime startTime = LocalTime.of(Integer.valueOf(tempArray[0]), Integer.valueOf(tempArray[1]));
                Course course = new Course(Department.valueOf(department),courseNumber,sectionNumber,startTime);
                tempList.add(course);
            }
        }
        this.registrar = tempList;
    }

    public ArrayList<Course> getRegistrar() {
        return registrar;
    }
}
