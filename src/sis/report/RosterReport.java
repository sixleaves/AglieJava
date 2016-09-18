package sis.report;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Student;

/**
 * Created by sixleaves on 16/8/22.
 */
public class RosterReport {
    // const
    public final static String ROSTER_REPORT_HEADER = "------\n";
    public final static String ROSTER_REPORT_FOOTER = "------\n";
    private final static String NEW_LINE = "\n";
    private CourseSession _session;
    private String _report;
    public RosterReport(CourseSession session) {
        _session = session;
    }

    public String getReport() {

        StringBuilder report = new StringBuilder();
        report.append(ROSTER_REPORT_HEADER);

        int studentSize = _session.getStudentSize();
        for (int i = 0; i < studentSize; i++) {
            Student stu = _session.get(i);
            report.append(stu.getName());
            report.append(NEW_LINE);
        }

        report.append(ROSTER_REPORT_FOOTER);
        report.append(studentSize + NEW_LINE);
        return report.toString();
    }
}
