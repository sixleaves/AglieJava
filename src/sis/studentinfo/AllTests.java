package sis.studentinfo; /**
 * Created by sixleaves on 16/8/12.
 */
import junit.framework.TestSuite;
import sis.report.RosterReportTest;

public class AllTests{

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(StudentTest1.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(RosterReportTest.class);
        suite.addTestSuite(DateUtilTest.class);
        return suite;
    }
}
