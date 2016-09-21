package sis.studentinfo;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by sixleaves on 16/9/21.
 */
/*
* 大学需要有夏季课程安排.夏季学期从六月初开始, 一共有8周, 期间没有中断.
* */
public class SummerCourseSession extends CourseSession{

    public static SummerCourseSession create(String courseName,
                                      String courseNumber,
                                      Date startDate) {
        return new SummerCourseSession(courseName, courseNumber, startDate);
    }

    private SummerCourseSession(String courseName,
                                String courseNumber,
                                Date startDate) {
        super(courseName, courseNumber, startDate);
    }

    @Override
    public Date getEndDate() {

        int sessionLength = 8;
        int daysInWeek = 7;
        int days = daysInWeek * sessionLength - 1;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(_startDate);
        calendar.add(calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

}
