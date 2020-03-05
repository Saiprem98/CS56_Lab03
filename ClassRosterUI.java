// Sai Kathika - 5528633
import java.util.Scanner;

public class ClassRosterUI {
	
	 private static Scanner input = new Scanner(System.in);
	public static void printMenu() {
		//Prints the menu options to the console.
		System.out.println("----------");
		System.out.println("ac: Add Course\n" + 
				"dc: Drop Course\n" + 
				"as: Add Student\n" + 
				"ds: Drop Student\n" + 
				" p: Print ClassRoster\n" + 
				" q: Quit Program");
		System.out.println("----------");
		//System.out.print("Enter Command: ");
		
	}
	public static String getCommand() {
		//Gets the command from the user. Loops until the user enters a valid command and returns the valid command.
		String command = "";
		boolean keepRunning = true;
		while(keepRunning = true) {
			System.out.print("Enter Command: ");
			command = input.nextLine();
			 if (command.equalsIgnoreCase("AC")||command.equalsIgnoreCase("DC")|| command.equalsIgnoreCase("AS")
                 ||command.equalsIgnoreCase("DS")|| command.equalsIgnoreCase("P")|| command.equalsIgnoreCase("Q")) {
                return command;
            }
				System.out.println("Invalid option");
		}
		return command;
	}
	public static String getUserCourseCode(){
		System.out.print("Enter Course Code: ");
		 String courseCode = input.nextLine();
		 return courseCode;
	}
	public static String getUserCourseName(){
		 System.out.print("Enter Course Name: ");
		 String name = input.nextLine();
		 return name;
	}
	public static String getStudentCourseCode(){
			 System.out.print("Enter course code for Student: ");
			 String studentCourseCode = input.nextLine();
			 return studentCourseCode;
	}
	public static String getStudentFirstName(){
				System.out.print("Enter first name: ");
				String fName = input.nextLine();
				return fName;
	}
	public static String getStudentLastName(){
				System.out.print("Enter last name: ");
				String lName = input.nextLine();
				return lName;
	}
	public static int getStudentPerm(){
	// 			System.out.print("Enter PERM: ");
	// 			int perm =0;
	// 			boolean gotInt = false;
	// 			while (gotInt == false){
	// 			if(input.hasNextInt()){
	// 				perm = input.nextInt();
	// 				input.nextLine();
	// 				gotInt = true;
	// 			}
	// 			else{
	// 				System.out.print("Enter PERM: ");
	// 			}
	// 		}
	// 			return perm;
			boolean gotInt = true;
			while(gotInt){
				try{
					System.out.print("Enter PERM: ");
					int perm = Integer.parseInt(input.nextLine());
					if (perm <= 0){
						throw new Exception();
					}
					return perm;
				}
				catch( Exception e){
					//System.out.print("Enter PERM: ");
				}
			}
			return 0;
	 }

}
