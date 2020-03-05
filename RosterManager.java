// Sai Kathika - 5528633
import java.util.Scanner;

public class RosterManager {
	public static final int maxCourses = 10;
	private int totNumCourses;
	private Course [] arrayCourses; 
	//Scanner input;
	
	public RosterManager() {
		totNumCourses = 0;
		arrayCourses = new Course[maxCourses];
		//Scanner input = new Scanner(System.in);
	}
	public void run() {
		
		String inputCommand = "";
		System.out.println("Welcome to Class Roster Manager!");
		System.out.println("Select an action based on the following menu: ");
		boolean enterQuit = false; 
		while (enterQuit == false){
		try{
			ClassRosterUI.printMenu();
		inputCommand = ClassRosterUI.getCommand();

		 if(inputCommand.equalsIgnoreCase("Q")) {
			 enterQuit = true;
		 }
		 else if (inputCommand.equalsIgnoreCase("DC")) {
			String courseCode = ClassRosterUI.getUserCourseCode();
			 deleteCourse(courseCode);
		 }
		 else if(inputCommand.equalsIgnoreCase("AC")) {
		 	String courseCode = ClassRosterUI.getUserCourseCode();
		 	String courseName = ClassRosterUI.getUserCourseName();
			 Course course = new Course(courseCode,courseName);
			 addCourse(course);
		 }
		 else if (inputCommand.equalsIgnoreCase("AS")) {
			 Student s1 = new Student();
			 	String studentCourseCode = ClassRosterUI.getStudentCourseCode();
			 	int perm = ClassRosterUI.getStudentPerm();
				s1.setPermNum(perm);
				String fName = ClassRosterUI.getStudentFirstName();
				s1.setFirstName(fName);
				String lName = ClassRosterUI.getStudentLastName();
				s1.setLastName(lName);
			 addStudent(studentCourseCode,s1);
		 }
		 else if (inputCommand.equalsIgnoreCase("DS") ) {
			String courseC = ClassRosterUI.getStudentCourseCode();
		
			 int delPerm = ClassRosterUI.getStudentPerm();
			 deleteStudent(delPerm, courseC);
		 }
		 else if(inputCommand.equalsIgnoreCase("P")) {
			 printRoster();
		  }
		}catch ( Exception e){
			 System.out.println(e.getMessage());
			 //continue;
			}

		}
	}
	public void addCourse(Course c) throws DuplicateCourseException, CourseLimitException 
	{
		if (totNumCourses >= maxCourses) {
			throw new CourseLimitException();
		}
		 boolean found = false;
		for(int i = 0 ; i<totNumCourses; i++) {
				if(arrayCourses[i].getCourseCode().equalsIgnoreCase(c.getCourseCode())) {
					found = true;
				}

			}
		if(found) {
			throw new DuplicateCourseException();
			//continue;
		}
		arrayCourses[totNumCourses++] = c;
	}
	public void deleteCourse(String courseCode) throws CourseNotFoundException, EmptyCourseListException
	{
		if (totNumCourses == 0) {
		 throw new EmptyCourseListException();
		}
		boolean found = false;
		int indexFound = 0;
		for(int i = 0 ; i<totNumCourses; i++) {
				if(arrayCourses[i].getCourseCode().equalsIgnoreCase(courseCode)) {
					indexFound = i;
					found = true;
				}
			}
		if(found == false) {
			throw new CourseNotFoundException();
		}
		for (int j = indexFound ; j < totNumCourses-1; j++) {
			arrayCourses[j] = arrayCourses[j+1];
		}
		--totNumCourses;
	}
	public void addStudent(String courseCode, Student s) throws StudentLimitException,DuplicateStudentException,CourseNotFoundException
	{
		boolean found = false;
		int indexFound = 0;
		for(int i = 0 ; i<totNumCourses; i++) {
				if(arrayCourses[i].getCourseCode().equalsIgnoreCase(courseCode)) {
					indexFound = i;
					found = true;
				}
			}

		if(found == false) {
			throw new CourseNotFoundException();
			}
		else if(found == true) {
			 arrayCourses[indexFound].addStudent(s);
		}
	}
	public void deleteStudent(int id, String courseCode) throws EmptyStudentListException, StudentNotFoundException, CourseNotFoundException 
	{
		boolean found = true;

		int indexFound = 0;
		for(int i = 0 ; i<totNumCourses; i++) {
				//String compare = arrayCourses[i].getCourseCode();
				if(arrayCourses[i].getCourseCode().equalsIgnoreCase(courseCode)) {
					//System.out.println(arrayCourses[i].getCourseCode());
					indexFound = i;
					found = false;	
				}
		}
		if (found == true ) {
				throw new CourseNotFoundException();
			}
		arrayCourses[indexFound].removeStudent(id);
		
	}
	public void printRoster() {
		//Prints the information for all courses and their enrolled students.
		System.out.println("********************");
		for (int i = 0 ; i < totNumCourses; i++) {
			System.out.println(arrayCourses[i].getCourseCode()+": " + arrayCourses[i].getCourseName());
			System.out.println("Enrolled: " + arrayCourses[i].getCurrentNumEnrol());
			for(int j = 0; j<arrayCourses[i].getCurrentNumEnrol();j++) {
				System.out.print("	" + arrayCourses[i].getArrayOfStudents(j).getPermNum());
				System.out.print(" | "); 
				System.out.print(arrayCourses[i].getArrayOfStudents(j).getLastName());
				System.out.print(", ");
				System.out.print(arrayCourses[i].getArrayOfStudents(j).getFirstName());
				System.out.println();
			}
		}
		System.out.println("********************");
	}
}
