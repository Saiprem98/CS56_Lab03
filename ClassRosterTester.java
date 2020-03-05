import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

public class ClassRosterTester {

	@Test
	public void testMaxCourses() {
		RosterManager m1 = new RosterManager();

		try {
			for (int i = 0; i < RosterManager.maxCourses+1; i++) {
//				Random random = new Random();
//				int x = random.nextInt();
				m1.addCourse(new Course(""+i,""+i));
			}
		}
		catch(CourseLimitException e) {
				return;
			}
		catch (Exception e) {	       
	            fail();
	        }
		fail();
	}
	@Test
	public void testDuplicateCourses() {
		RosterManager m1 = new RosterManager();
		try {
			m1.addCourse(new Course("cs56","cs56"));
			m1.addCourse(new Course("cs56","cs56"));
		}
		catch(DuplicateCourseException e) {
			return;
		}
		catch (Exception e) {       
            fail();
        }

        fail();
	}
	@Test
	public void testNoCourse() {
		RosterManager m1 = new RosterManager();
		try {
			m1.addCourse(new Course("cs56","cs56"));
			m1.deleteCourse("cs130a");
		}
		catch(CourseNotFoundException e) {
			return;
		}
		catch (Exception e) {       
            fail();
        }
        fail();
	}
	@Test
	public void testEmptyCourse() {
		RosterManager m1 = new RosterManager();
		try {
			m1.deleteCourse("cs130a");
		}
		catch(EmptyCourseListException e) {
			return;
		}
		catch (Exception e) {       
            fail();
        }
        fail();
	}
	@Test
	public void testMaxStudents() {
		RosterManager m1 = new RosterManager();
		try {
			m1.addCourse(new Course("cs56","cs56"));
			for (int i = 0; i < Course.maxStudents +1 ; i++) {
				m1.addStudent("cs56", new Student(i,"sk","sck"));
			}
		}
		catch (StudentLimitException e) {
			return;
		}
		catch (Exception e) {       
            fail();
        }
        fail();
	}
	@Test
	public void testDuplicateStudents() {
		RosterManager m1 = new RosterManager();
		try {
			m1.addCourse(new Course("cs56","cs56"));
			m1.addStudent("cs56", new Student(3,"sk","sck"));
			m1.addStudent("cs56", new Student(3,"sk","sck"));
		}
		catch (DuplicateStudentException e) {
			return;
		}
		catch (Exception e) {       
            fail();
        }
        fail();
	}
	//StudentNotFoundException
//	@Test
//	public void testNoStudentFound() {
//		RosterManager m1 = new RosterManager();
//		try {
//			m1.addCourse(new Course("cs56","cs56"));
//			m1.addStudent("cs56", new Student(3,"",""));
//		}
//		catch(EmptyStudentListException e) {
//			return;
//		}
//		catch (Exception e) {       
//            fail();
//        }
//        fail();
//	}
	@Test
	public void testCourseNotFound() {
		RosterManager m1 = new RosterManager();
		try {
		m1.addCourse(new Course("cs56","cs56"));
		m1.addStudent("cs30", new Student(3,"ds","das"));
	}
	catch(CourseNotFoundException e) {
		return;
	}
	catch (Exception e) {       
        fail();
    }
    fail();
	}
	@Test
	public void testCourseNotFoundDel() {
		RosterManager m1 = new RosterManager();
		try {
		m1.addCourse(new Course("cs56","cs56"));
		m1.addStudent("cs56", new Student(3,"sk","sck"));
		m1.deleteStudent(3 ,"cs130" );
	}
	catch(CourseNotFoundException e) {
		return;
	}
	catch (Exception e) {       
        fail();
    }
    fail();
	}
	@Test
	public void testStudentNotFound(){
		RosterManager m1 = new RosterManager();
		try {
			m1.addCourse(new Course("cs56","cs56"));
			m1.addStudent("cs56", new Student(3,"sk","sck"));
			m1.deleteStudent(1,"cs56");
		}
		catch(StudentNotFoundException e) {
			return;
		}
		catch (Exception e) {       
	        fail();
	    }
	    fail();
	}
	@Test
	public void testEmptyStudentList() {
		RosterManager m1 = new RosterManager();
		try {
			m1.addCourse(new Course("cs56","cs56"));
			m1.deleteStudent(3,"cs56");
		}
		catch(EmptyStudentListException e) {
		return;
	}
	catch (Exception e) {       
        fail();
    }
    fail();
	}
}
