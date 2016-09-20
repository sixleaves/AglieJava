package sis.report;

/**
 * Created by admini on 16/9/19.
 */

import junit.framework.*;
import java.util.*;
import sis.studentinfo.*;
import static sis.report.ReportConstant.*;

public class CourseReportTest extends TestCase{

    public void testReport() {

        CourseReport courseReport = new CourseReport();
        final Date date = new Date();
        courseReport.add(CourseSession.create("ENG", "101", date));
        courseReport.add(CourseSession.create("ENG", "95", date));
        courseReport.add(CourseSession.create("CZEC", "200", date));
        courseReport.add(CourseSession.create("CZEC", "210", date));
        courseReport.add(CourseSession.create("ITAL", "410", date));
        assertEquals(
                        "CZEC 200" + NEWLINE +
                        "CZEC 210" + NEWLINE +
                        "ENG 101" + NEWLINE +
                        "ENG 95" + NEWLINE +
                        "ITAL 410" + NEWLINE, courseReport.text());
    }

    public void testSortStringInPlace() {

        ArrayList<String> list = new ArrayList<String>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        java.util.Collections.sort(list);
        assertEquals("Boyle", list.get(0));
        assertEquals("Camus", list.get(1));
        assertEquals("Heller", list.get(2));
        assertEquals("Kafka", list.get(3));

    }

    public void testSortStringInNewList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        ArrayList<String> sortedList = new ArrayList<String>(list);
        java.util.Collections.sort(sortedList);
        assertEquals("Boyle", sortedList.get(0));
        assertEquals("Camus", sortedList.get(1));
        assertEquals("Heller", sortedList.get(2));
        assertEquals("Kafka", sortedList.get(3));

        assertEquals("Heller", list.get(0));
        assertEquals("Kafka", list.get(1));
        assertEquals("Camus", list.get(2));
        assertEquals("Boyle", list.get(3));

    }

}
