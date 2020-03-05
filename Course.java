// Sai Kathika - 5528633
import java.util.Arrays; 
public class Course {
	public static final int maxStudents = 50;
	private String courseCode;
	private String courseName;
	private int currentNumEnroll; 
	private Student [] studentsEnroll;
	
	public Course() {
		studentsEnroll = new Student[maxStudents];
	}
	public Course(String courseCode, String courseName) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		studentsEnroll = new Student[maxStudents];
	}
	public void addStudent(Student s) throws StudentLimitException, DuplicateStudentException {
		//Adds a student to the course. The student array order will need to be maintained (see requirements above).
		if(currentNumEnroll >= studentsEnroll.length) {
			throw new StudentLimitException();
		}
		for ( int i = 0 ; i < currentNumEnroll; i++) {
			if(studentsEnroll[i].getPermNum() == s.getPermNum()) {
				throw new DuplicateStudentException();
			}
		}
		 studentsEnroll[currentNumEnroll++] = s;
		// String [] strings = new String[currentNumEnroll];
		// for(int j =0 ; j<currentNumEnroll; j++ ){
		// 	strings[j] = studentsEnroll[j].getLastName();
		// }
		// Arrays.sort(strings);
		for(int i = 0; i < currentNumEnroll-1; i++){
			if(studentsEnroll[i].getLastName().compareTo(studentsEnroll[i+1].getLastName()) > 0){
				Student temp = studentsEnroll[i+1];
				studentsEnroll[i+1] = studentsEnroll[i];
				studentsEnroll[i] = temp;
			}
			if(studentsEnroll[i].getLastName().compareTo(studentsEnroll[i+1].getLastName()) == 0){
				if (studentsEnroll[i].getPermNum() > studentsEnroll[i+1].getPermNum() ){
				Student temp1 = studentsEnroll[i+1];
				studentsEnroll[i+1] = studentsEnroll[i];
				studentsEnroll[i] = temp1;
				}
			}
		}
	}
	public void removeStudent(int studentId) throws EmptyStudentListException, StudentNotFoundException
	{
		if (currentNumEnroll == 0) {
			throw new EmptyStudentListException();
		}
		for ( int i = 0 ; i < currentNumEnroll; i++) {
			if(studentsEnroll[i].getPermNum() == studentId) {
				for (int j = i; j < currentNumEnroll-1;j++ ) {
				studentsEnroll[j] = studentsEnroll[j+1];
			}
				currentNumEnroll--;
				return;
		}
		
	}
		throw new StudentNotFoundException();
	}
	public Student getArrayOfStudents(int index) {
		return studentsEnroll[index];
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseC) {
		courseCode = courseC;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseN) {
		courseName = courseN;
	}
	public int getCurrentNumEnrol() {
		return currentNumEnroll;
	}
	public void setCurrentNumEnroll( int enroll) {
		currentNumEnroll = enroll ;
	}
}
