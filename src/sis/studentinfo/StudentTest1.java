package sis.studentinfo;

/**
 * Created by sixleaves on 16/8/11.
 */
public class StudentTest1 extends junit.framework.TestCase {
    static final int GRADE_TOLERANCE = 5 / 100;
    public void testCreate() {
        // 请重构代码, 并说明原因
        final String firstStudentName = "SuWeiPeng";
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudent.getName(), firstStudentName);

        final String secondStudentName = "WangDongLiang";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudent.getName(), secondStudentName);
    }

    public void testFullTime() {
        Student student = new Student("a");
        assertFalse(student.isFullTime());
    }

    public void testCredits() {
        Student student = new Student("a");
        assertEquals(0, student.getCredits());
        student.addCredits(1);
        assertEquals(1, student.getCredits());
        student.addCredits(5);
        assertEquals(6, student.getCredits());
    }

    public void testStudentStatus() {
        Student student = new Student("a");
        assertFalse(student.isFullTime());
        student.addCredits(3);
        assertFalse(student.isFullTime());
        student.addCredits(7);
        assertFalse(student.isFullTime());
        student.addCredits(2);
        assertTrue(student.isFullTime());
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
        student.addCredits(3);
        assertTrue(student.isFullTime());
        student.addCredits(-3);
        assertTrue(student.isFullTime());
        student.addCredits(-13);
        assertFalse(student.isFullTime());
    }

    public void testStudentState() {

        Student student = new Student("a");
        assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());

    }

    public void testGpa() {

        Student student = new Student("a");
        assertGpa(student, 0);

        student.addGrade(Student.Grade.A);
        assertGpa(student, 4.0);

        student.addGrade(Student.Grade.B);
        assertGpa(student, 3.5);

        student.addGrade(Student.Grade.C);
        assertGpa(student, 3.0);

        student.addGrade(Student.Grade.D);
        assertGpa(student, 2.5);

        student.addGrade(Student.Grade.F);
        assertGpa(student, 2.0);
    }

    public void assertGpa(Student student, double gpa) {
        assertEquals(gpa, student.getGpa(), GRADE_TOLERANCE);
    }



}
