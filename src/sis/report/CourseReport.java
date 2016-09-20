package sis.report;

import sis.studentinfo.CourseSession;

import java.util.ArrayList;
import java.util.Collections;

import static sis.report.ReportConstant.NEWLINE;

/**
 * Created by admini on 16/9/19.
 */
public class CourseReport {

    private ArrayList<CourseSession> _sessions = new ArrayList<CourseSession>();

    public void add(CourseSession session) {
        _sessions.add(session);
    }

    public String text() {
        StringBuilder text = new StringBuilder();
        Collections.sort(_sessions);
        for (CourseSession session: _sessions) {
            text.append(session.getCourseName() + " " + session.getCourseNumber() + NEWLINE);
        }
        return text.toString();
    }


}
