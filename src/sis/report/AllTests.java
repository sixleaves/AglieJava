package sis.report;
import junit.framework.TestSuite;
/**
 * Created by sixleaves on 16/8/22.
 */
public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(RosterReportTest.class);
        suite.addTestSuite(CourseReportTest.class);
        suite.addTestSuite(CardReportTest.class);
        return suite;
    }
}
