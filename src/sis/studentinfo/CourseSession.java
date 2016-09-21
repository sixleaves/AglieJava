package sis.studentinfo; /**
 * Created by sixleaves on 16/8/12.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * CourseSession对象, 是课程安排对象.表示某门课程的安排(课程名称和课程编号)和参与的学生.
 *
 * */
public class CourseSession extends Session {

    @Override
    public int getSessionLength() {
        return 16;
    }

    @Override
    public int getDaysFromFridayToMonday() {
        return 3;
    }

    public static CourseSession create(String department, String number, Date startDate) {
        CourseSession.incrementCount();
        CourseSession courseSession =new CourseSession(department, number, startDate);
        courseSession.setNumberOfCredits(3);
        return courseSession;
    }

    private CourseSession(String department, String number, Date startDate) {
        super(department, number, startDate);
    }

}

/**
 * 1.import语句的作用, 包的三个作用(1.分类,方便查找 2.方便模块重用与重构 3.提供命名控件功能)
 * 2.数组ArrayList的add(object), size(), get(index)方法的使用.
 * 3.构造方法的基本语法.(如果不声明, java会自动生成构造方法)
 * 4.包的文件系统结构
 * */
