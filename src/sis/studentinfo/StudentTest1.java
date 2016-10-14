package sis.studentinfo;

/**
 * Created by sixleaves on 16/8/11.
 */
public class StudentTest1 extends junit.framework.TestCase {
    static final int GRADE_TOLERANCE = 5 / 100;

    public void testCalculateHonorsStudentGps() {

        assertGpa(createHonorsStudent(), 0.0);
        assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
        assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
        assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
        assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
        assertGpa(createHonorsStudent(Student.Grade.F), 0);

    }

    private Student createHonorsStudent() { // 边界
        Student student = new Student("a");
        student.setHonors();
        return student;
    }

    private Student createHonorsStudent(Student.Grade grade) { // 正常输入
        Student student = new Student("a");
        student.setHonors();
        student.addGrade(grade);
        return student;
    }

    public void testCreate() {
        // 请重构代码, 并说明原因
//        final String firstStudentName = "SuWeiPeng";
//        Student firstStudent = new Student(firstStudentName);
//        assertEquals(firstStudent.getName(), firstStudentName);
//
//        final String secondStudentName = "WangDongLiang";
//        Student secondStudent = new Student(secondStudentName);
//        assertEquals(secondStudent.getName(), secondStudentName);

        final String firstStudentName = "Jane Noe";
        Student firstStudent = new Student(firstStudentName);
        assertEquals("Jane", firstStudent.getFirstName());
        assertEquals("", firstStudent.getMiddleName());
        assertEquals("Noe", firstStudent.getLastName());

        final String secondStudentName = "Jane";
        Student secondStudent = new Student(secondStudentName);
        assertEquals("", secondStudent.getFirstName());
        assertEquals("", secondStudent.getMiddleName());
        assertEquals("Jane", secondStudent.getLastName());

        final String thirdStudentName = "Jane Noe Davie";
        Student thirdStudent = new Student(thirdStudentName);
        assertEquals("Jane", thirdStudent.getFirstName());
        assertEquals("Noe", thirdStudent.getMiddleName());
        assertEquals("Davie", thirdStudent.getLastName());

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

    public void testBadlyFormatName() {
        try {
            Student student = new Student("a b c d");
            fail("expected exception from 4-part name");
        }catch (StudentNameFormatException e) {
            assertEquals("nameParts more than 3", e.getMessage());
        }
    }

}
