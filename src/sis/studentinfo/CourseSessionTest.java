package sis.studentinfo; /**
 * Created by sixleaves on 16/8/12.
 */
import junit.framework.TestCase;

import java.util.Date;

public class CourseSessionTest extends TestCase {

    private CourseSession _session;
    private Date _startDate;
    private final String _courseName = "ENG";
    private final String _courseNumber = "101";

    public void testCount() {
        CourseSession.resetCount();
        assertEquals(0, CourseSession.getCount());
        createCourseSession();
        assertEquals(1, CourseSession.getCount());
        createCourseSession();
        assertEquals(2, CourseSession.getCount());

    }

    public void testCreate() {


        assertEquals(_courseName, _session.getCourseName());
        assertEquals(_courseNumber, _session.getCourseNumber());
        assertEquals(0, _session.getStudentSize());

    }

//    public void testEnroll() {
//
//        ArrayList<Student> tempStudents = new ArrayList<Student>();
//
//        final String firstStudentName = "SuWeiPeng";
//        CourseSession session = new CourseSession("ENG", "101");
//        Student firstStudent = new Student(firstStudentName);
//        assertEquals(firstStudentName, firstStudent.getName());
//        session.enroll(firstStudent);
//        assertEquals(1, session.getStudentSize());
//        tempStudents.add(firstStudent);
//
//        final String secondStudentName = "WangDongLiang";
//        Student secondStudent = new Student(secondStudentName);
//        session.enroll(secondStudent);
//        assertEquals(2, session.getStudentSize());
//        tempStudents.add(secondStudent);
//
//        // 证明所添加的是学生对象, 并且添加成功
//        ArrayList<Student> students = session.getStudents();
//        for (int i = 0; i < students.size(); i++) {
//            assertEquals(tempStudents.get(i), students.get(i));
//        }
//    }

    public void testEnroll1() {

        // testEnroll代码还有改进的地方, 从面向对象的角度, 我们最好是不要暴露students成员变量.
        // 因为该数据接口属于内部的实现细节.如果暴露给外部, 那么外部代码很可能直接依赖与该数据接口.
        // 1.简单的说就是使用的时候, 就只能传数组, 后面要改变改数据结构就麻烦了.
        // 2.暴露还会造成无法监听到该数据的改变.
        // 比较好的做法是给改数据接口提供接口.通过接口来操作数据结构, 而不是字节暴露.
        // 提供get和add接口.
        final String firstStudentName = "SuWeiPeng";
        CourseSession session = new CourseSession("ENG", "101");
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudentName, firstStudent.getName());
        session.enroll(firstStudent);
        assertEquals(1, session.getStudentSize());
        assertEquals(firstStudent, session.get(0));

        final String secondStudentName = "WangDongLiang";
        Student secondStudent = new Student(secondStudentName);
        session.enroll(secondStudent);
        assertEquals(2, session.getStudentSize());
        assertEquals(secondStudent, session.get(1));

    }

    public void testCourseDate() {

        CourseSession session = new CourseSession("ABCD", "200",_startDate);

        Date sixteenWeekOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeekOut, session.getEndDate());
    }

    public void setUp() {
        _startDate = DateUtil.createDate(2003, 1, 6);
        _session = new CourseSession(_courseName, _courseNumber);
    }


    private CourseSession createCourseSession() {
        return new CourseSession("ENGL", "101", _startDate);
    }


}
