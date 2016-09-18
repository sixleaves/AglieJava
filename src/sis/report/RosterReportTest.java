package sis.report;
import junit.framework.TestCase;
import sis.studentinfo.CourseSession;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Student;

/**
 * Created by sixleaves on 16/8/22.
 */
/*
* 1.任何测试用例都应该继承TestCase
* */
public class RosterReportTest extends TestCase {

    public void testRosterReport() {

        CourseSession session = new CourseSession("ENG","101", DateUtil.createDate(2003, 1, 6));

        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

        String rosterReport = new RosterReport(session).getReport();
        assertEquals(RosterReport.ROSTER_REPORT_HEADER +
                "A\nB\n" +
                RosterReport.ROSTER_REPORT_FOOTER + "2\n", rosterReport);
    }



}
