package sis.studentinfo;

import junit.framework.TestCase;

import java.net.MalformedURLException;
import java.util.Date;

/**
 * Created by sixleaves on 16/9/22.
 */
abstract public class SessionTest extends TestCase {

    private Session _session;
    private Date _startDate;
    private final String _courseName = "ENG";
    private final String _courseNumber = "101";
    protected static final int CREDITS = 3;

    public void testCount() {
        Session.resetCount();
        assertEquals(0, Session.getCount());
        createSession("", "", _startDate);
        assertEquals(1, Session.getCount());
        createSession("", "", _startDate);
        assertEquals(2, Session.getCount());
    }

    public void testCreate() {


        assertEquals(_courseName, _session.getCourseName());
        assertEquals(_courseNumber, _session.getCourseNumber());
        assertEquals(0, _session.getStudentSize());

    }

    public void testEnroll() {

        // testEnroll代码还有改进的地方, 从面向对象的角度, 我们最好是不要暴露students成员变量.
        // 因为该数据接口属于内部的实现细节.如果暴露给外部, 那么外部代码很可能直接依赖与该数据接口.
        // 1.简单的说就是使用的时候, 就只能传数组, 后面要改变改数据结构就麻烦了.
        // 2.暴露还会造成无法监听到该数据的改变.
        // 比较好的做法是给改数据接口提供接口.通过接口来操作数据结构, 而不是字节暴露.
        // 提供get和add接口.
        final String firstStudentName = "SuWeiPeng";
        Session session = createSession("", "", _startDate);
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudentName, firstStudent.getName());
        session.enroll(firstStudent);
        assertEquals(CREDITS, firstStudent.getCredits());
        assertEquals(1, session.getStudentSize());
        assertEquals(firstStudent, session.get(0));

        final String secondStudentName = "WangDongLiang";
        Student secondStudent = new Student(secondStudentName);
        session.enroll(secondStudent);
        assertEquals(2, session.getStudentSize());
        assertEquals(CREDITS, secondStudent.getCredits());
        assertEquals(secondStudent, session.get(1));

    }

    public void testEndDate() {
        Session session = createSession("ABCD", "200",_startDate);
        Date sixteenWeekOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeekOut, session.getEndDate());
    }

    public void setUp() {
        _startDate = DateUtil.createDate(2003, 1, 6);
        _session =  createSession("ENG", "101", _startDate);
    }

    public void testSessionURL() throws SessionException{
        final String url = "http://www.baidu.com";
        _session.setUrl(url);
        assertEquals(url, _session.getUrl().toString());
    }

    public void testInvalidSessionURL() {
        final String url = "httpz://www.baidu.com";
        try {
            _session.setUrl(url);
            fail("expected exception due to invalid protocol in URL");
        }catch (SessionException e) {

        }


    }


    abstract Session createSession(String courseName, String courseNumber, Date startDate);


}
