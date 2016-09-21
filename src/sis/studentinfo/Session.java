package sis.studentinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by sixleaves on 16/9/22.
 */
abstract public class Session implements Comparable<CourseSession> {

    private int _numberOfCredits;
    private static int count;
    private String _courseName;
    private String _courseNumber;
    private ArrayList<Student> _students = new ArrayList<Student>();
    protected Date _startDate;

    abstract public int getSessionLength();
    abstract public int getDaysFromFridayToMonday();
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


    public static void incrementCount() {
        Session.count = Session.count + 1;
    }

    public static void resetCount() {
        Session.count = 0;
    }

    public static int getCount() {
        return Session.count;
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

    /**
     * @return int
     * @author suweipeng
     * */
    public int getStudentSize() {
        return _students.size();
    }

    public Session(String courseName, String courseNumber) {
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
    protected Session(String courseName, String courseNumber, Date startDate) {
        _setUp(courseName, courseNumber);
        _startDate = startDate;
    }

    public Date getEndDate() {
        int days = 7 * getSessionLength() - getDaysFromFridayToMonday();
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
