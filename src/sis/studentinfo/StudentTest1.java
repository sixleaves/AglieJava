package sis.studentinfo;

/**
 * Created by sixleaves on 16/8/11.
 */
public class StudentTest1 extends junit.framework.TestCase {
    public void testCreate() {
        // 请重构代码, 并说明原因
        final String firstStudentName = "SuWeiPeng";
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudent.getName(), firstStudentName);

        final String secondStudentName = "WangDongLiang";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudent.getName(), secondStudentName);
    }
}
