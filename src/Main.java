import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("\n\nHello, RegistrationApp!\n");

        //Read and stores curriculum.dat.
        Curriculum curriculum = new Curriculum("curriculum.dat");
        System.out.println("Curriculum:\n" + curriculum.formatCurriculumForOutput());

        //Obtains the sum of all credit hours in the curriculum.
        int sumOfCurriculumCreditHours = curriculum.calculateCreditHoursSum();
        System.out.println( "The sum of the credit hours for the curriculum is " + sumOfCurriculumCreditHours);

        //Obtains the number of courses from a specified department in the curriculum.
        System.out.println("Enter the department you are searching for: ");
        String departmentSearch = sc.next();
        System.out.println("There are " + curriculum.getNumberOfCoursesOfDepartment(departmentSearch) + " courses from the " + departmentSearch + " department in the curriculum.");

        //Checks if a specified course is in the curriculum or if the specified course can fulfil a course category. There is a separate constructor for Registrar the asks for the length of each course individually.
        System.out.println("Enter the length of all courses in terms of minutes.");
        Integer lengthOfAllCoursesInMinutes = sc.nextInt();
        Registrar registrar = new Registrar("registrar.txt", lengthOfAllCoursesInMinutes);
        System.out.println("Enter the course you are searching for: ");
        String course = sc.next() + " " + sc.next();
        if (curriculum.checkIfContainsCourse(course, registrar)){
            System.out.println(course + " is in the curriculum.");
        }
        else {
            System.out.println(course + " is not in the curriculum.");
        }

        //Reads and stores transcript.txt
        Transcript transcript = new Transcript("transcript.txt");
        System.out.println("Transcript:\n" + transcript.formatForOutput());

        //Obtains the sum of all credit hours in the transcript.
        Integer transcriptCreditHoursSum = transcript.calculateCreditHoursSum();
        System.out.println("The sum of the credit hours for the transcript is " + transcriptCreditHoursSum);

        //Checks courses in the transcript if they are in the curriculum and represents it with a map of the courses and a corresponding boolean value.
        Map<String, Boolean> transcriptInCurriculumMap = transcript.checkIfTranscriptCourseInCurriculum(curriculum, registrar);
        System.out.println("The map of the courses and their boolean value in relation to their status of being present in the curriculum is:\n" + transcriptInCurriculumMap);

        //Checks if a specified course is in the transcript.
        System.out.println("Enter the course you are searching for with its corresponding number of credit hours: ");
        CourseTranscript courseTranscriptSearch = new CourseTranscript(Department.valueOf(sc.next()), sc.nextInt(), sc.nextInt());
        if (transcript.checkIfContainsCourse(courseTranscriptSearch)){
            System.out.println(courseTranscriptSearch.getCourseAndCreditHours() + " is in the transcript.");
        }
        else {
            System.out.println(courseTranscriptSearch.getCourseAndCreditHours() + " is not in the transcript.");
        }

        //Checks if the courses in the transcript are enough to complete all curriculum requirement to graduate.
        if (transcript.checkIfAllCurriculumRequirementsAreCompleted(curriculum, registrar)){
            System.out.println("All curriculum requirements have been met. Student is eligible to graduate.");
        }
        else {
            System.out.println("All curriculum requirements have not been met. Student is not eligible to graduate.");
        }
        
        //Reads curriculum.dat and stores each line as a String, Integer Map.
        /**Map<String, Integer> curriculumMap = new HashMap<>();
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
        }**/
    }
    //Function to read a file with courses followed by credit hours and store this information into a String, Integer Map.
    /**private static Map<String, Integer> readAndStoreFileWithCoursesAndCreditHours (File file) throws FileNotFoundException {
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
    }**/
}
