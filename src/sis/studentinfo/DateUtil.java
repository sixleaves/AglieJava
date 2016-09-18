package sis.studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by sixleaves on 16/8/22.
 */
public class DateUtil {

    public static Date createDate(int year, int month, int day) {
//        Date startDate = new Date(year - 1900, month - 1, day);
//        return startDate;
        // 用Calendar创建日期
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

}
