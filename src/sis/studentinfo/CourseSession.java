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
public class CourseSession implements Comparable<CourseSession>{

    private int _numberOfCredits;
    private static int count;
    private String _courseName;
    private String _courseNumber;
    private ArrayList<Student> _students = new ArrayList<Student>();
    private Date _startDate;


    @Override
    public int compareTo(CourseSession o) {
        int compare = getCourseName().compareTo(o.getCourseName());
        if (compare == 0) compare = getCourseNumber().compareTo(o.getCourseNumber());
        return compare;
    }

    // const
    /* Refactor
    public final static String ROSTER_REPORT_HEADER = "------\n";
    public final static String ROSTER_REPORT_FOOTER = "------\n";
    */
    public static CourseSession create(String department, String number, Date startDate) {
        CourseSession.incrementCount();
        return new CourseSession(department, number, startDate);
    }

    public static void incrementCount() {
        CourseSession.count = CourseSession.count + 1;
    }

    public static void resetCount() {
        CourseSession.count = 0;
    }

    public static int getCount() {
        return CourseSession.count;
    }

    public String getCourseName() {
        return _courseName;
    }

    public String getCourseNumber() {
        return _courseNumber;
    }

    public void setCourseName(String courseName) {
        _courseName = courseName;
    }

    public void setCourseNumber(String courseNumber) {
        _courseNumber = courseNumber;
    }


    // depre
//    public void setStudents(ArrayList<Student> students) {
//        _students = students;
//    }

//    public ArrayList<Student> getStudents() {
//        return _students;
//    }

/**
 * @return int
 * @author suweipeng
 * */
    public int getStudentSize() {
        return _students.size();
    }

    public CourseSession(String courseName, String courseNumber) {
        _setUp(courseName, courseNumber);
    }
    /**
     *
     * @param courseName
     * @param courseNumber
     * @param startDate
     * @return null
     * @author SuWeiPeng
     * */
    private CourseSession(String courseName, String courseNumber, Date startDate) {
        _setUp(courseName, courseNumber);
        _startDate = startDate;
    }

    public Date getEndDate() {

        int days = 7 * 16 - 3;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(_startDate);
        calendar.add(calendar.DAY_OF_YEAR, days);
        return calendar.getTime();

    }

    private void _setUp(String courseName, String courseNumber) {
        _courseName = courseName;
        _courseNumber = courseNumber;
    }

    public Student get(int index) {
        if (index < 0 || index >= this.getStudentSize()) {
            throw new Error();
        }
        return _students.get(index);
    }

    public void enroll(Student student) {
        student.addCredits(getNumberOfCredits());
        _students.add(student);
    }


    public void setNumberOfCredits(int numberOfCredits) {
        _numberOfCredits = numberOfCredits;
    }

    public int getNumberOfCredits() {
        return _numberOfCredits;
    }
}

/**
 * 1.import语句的作用, 包的三个作用(1.分类,方便查找 2.方便模块重用与重构 3.提供命名控件功能)
 * 2.数组ArrayList的add(object), size(), get(index)方法的使用.
 * 3.构造方法的基本语法.(如果不声明, java会自动生成构造方法)
 * 4.包的文件系统结构
 * */
