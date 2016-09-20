package sis.studentinfo;

import java.util.ArrayList;

/**
 * Created by sixleaves on 16/8/11.
 */
public class Student {

    enum Grade {
        A, B, C, D, F
    }

    private String _state = "";
    private double _gpa = 0;
    private ArrayList<Grade> _grades = new ArrayList<Grade>();

    private String _name;

    private int _credits;

    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";

    public Student(String name) {
        _name = name;
    }

    public int getCredits() {
        return _credits;
    }

    public String getName() {
        return _name;
    }

    public boolean isFullTime() {
        // 将数字提取出来声明为类常量。
        return _credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public void addCredits(int credits) {
        _credits += credits;
    }

    public boolean isInState() {
        return _state.equals(IN_STATE);
    }

    public void setState(String state) {
        _state = state;
    }

    public double getGpa() {

        if (_grades.isEmpty()) return 0.0;
        double total = 0.0;
        for (Student.Grade grade : _grades) {
            total += gradePointsFor(grade);
        }
        return total / _grades.size();
    }

    public double gradePointsFor(Student.Grade grade) {
        if (grade.equals(Student.Grade.A)) return  4;
        if (grade.equals(Student.Grade.B)) return  3;
        if (grade.equals(Student.Grade.C)) return  2;
        if (grade.equals(Student.Grade.D))  return  1;
        return 0;
    }

    public void addGrade(Grade grade) {
        _grades.add(grade);
    }
}
