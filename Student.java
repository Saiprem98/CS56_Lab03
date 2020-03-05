// Sai Kathika - 5528633
public class Student {
	private int permNum;
	private String firstName;
	private String lastName;
	
	public Student() {
		
	}
	public Student(int permNum, String firstName, String lastName) {
		this.permNum = permNum;
		this.firstName= firstName;
		this.lastName = lastName;
	}
	public int getPermNum() {
		return permNum;
	}
	public void setPermNum(int perm) {
		permNum = perm;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first) {
		firstName = first; 
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last) {
		lastName = last; 
	}
}
