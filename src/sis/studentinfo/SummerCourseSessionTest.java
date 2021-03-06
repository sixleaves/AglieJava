package sis.studentinfo;

import junit.framework.TestCase;

import java.util.Date;

/**
 * Created by sixleaves on 16/9/21.
 */
public class SummerCourseSessionTest extends SessionTest {

    @Override
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2015, 6, 1);
        // 重构, 取名应该易读, 叫endDate, 人家只知道是结束日期, 而不知道是过了几周
        Date eightWeeksOut = DateUtil.createDate(2015, 7, 26);
        Session session = createSession("ENG", "101", startDate);
        assertEquals(eightWeeksOut, session.getEndDate());
    }


    @Override
    Session createSession(String courseName, String courseNumber, Date startDate) {

        return SummerCourseSession.create(courseName, courseNumber, startDate);
    }
}
