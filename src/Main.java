import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("\n\nHello, RegistrationApp!\n");

        //Reads curriculum.dat and stores each line as a String, Integer Map.
        Map<String, Integer> curriculumMap = new HashMap<>();
        File curriculumFile = new File("curriculum.dat");
        curriculumMap = readAndStoreFileWithCoursesAndCreditHours(curriculumFile);
        System.out.println("The map of the curriculum with courses as keys and credit hours as values is " + curriculumMap);

        //Obtains the sum of the credit hours in the curriculum.
        int sumOfCurriculumCreditHours = getIntSum(curriculumMap);
        System.out.println("The sum of the credit hours for the curriculum is " + sumOfCurriculumCreditHours);

        //Finds how many courses in the curriculum are in the specified department.
        ArrayList<String> specificDepartmentCoursesList = new ArrayList<>();
        System.out.println("Enter the department you are searching for: ");
        String department = sc.next();
        specificDepartmentCoursesList = findKeys(curriculumMap, department);
        System.out.println("The number of courses in the " + department + " department is " + specificDepartmentCoursesList.size());

        //Checks if the curriculum contains a specific course.
        System.out.println("Enter the course you are searching for: ");
        String course = sc.next();
        if (curriculumMap.containsKey(course)){
            System.out.println("The curriculum does contain the" + course + " course.");
        }
        else {
            System.out.println("The curriculum does not contain the" + course + " course.");
        }
    }
    //Function to read a file with courses followed by credit hours and store this information into a String, Integer Map.
    private static Map<String, Integer> readAndStoreFileWithCoursesAndCreditHours (File file) throws FileNotFoundException {
        Map<String, Integer> tempMap = new HashMap<>();
        try (Scanner scFile = new Scanner(file)){
            while( scFile.hasNext() ) {
                String tempString = scFile.nextLine();
                String[] tempStringArray = tempString.split(" ");
                tempString = String.join(" ", Arrays.copyOfRange(tempStringArray, 0, tempStringArray.length - 1)).trim();
                int tempInt = Integer.valueOf(tempStringArray[tempStringArray.length-1]);
                tempMap.putIfAbsent(tempString, tempInt);
            }
        }
        return tempMap;
    }
    //Function to get the sum of all integer values in a String, Integer map.
    private static int getIntSum (Map<String, Integer> map){
        int sum = 0;
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }
    //Function to find the keys of a String, Integer Map that contain a specified string.
    private static ArrayList<String> findKeys (Map<String, Integer> map, String stringPart){
        ArrayList<String> tempList = new ArrayList<>();
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            if (entry.getKey().contains(stringPart)){
                tempList.add(entry.getKey());
            }
        }
        return tempList;
    }
}
