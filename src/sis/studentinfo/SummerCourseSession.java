package sis.studentinfo;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by sixleaves on 16/9/21.
 */
/*
* 大学需要有夏季课程安排.夏季学期从六月初开始, 一共有8周, 期间没有中断.
* */
public class SummerCourseSession extends Session {

    public static SummerCourseSession create(String courseName,
                                      String courseNumber,
                                      Date startDate) {
        incrementCount();
        SummerCourseSession session =new SummerCourseSession(courseName, courseNumber, startDate);
        session.setNumberOfCredits(3);
        return session;
    }

    private SummerCourseSession(String courseName,
                                String courseNumber,
                                Date startDate) {
        super(courseName, courseNumber, startDate);
    }

    @Override
    public int getDaysFromFridayToMonday() {
        return 1;
    }

    @Override
    public int getSessionLength() {
       return 8;
    }
}
