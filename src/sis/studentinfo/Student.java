package sis.studentinfo;

import java.util.ArrayList;

/**
 * Created by sixleaves on 16/8/11.
 */
public class Student {

    // 增加判断荣誉学生的功能, 不可扩展。
    // 一旦编码起来, 容易照成需求要添加其它类型的学生,就需要更改其student类
    // 而依赖于student的类就很可能得跟着做更改。
    private boolean _isHonors = false;
    private GradingStrategy _gradingStrategy = new RegularGradingStrategy();

    public void setHonors() {
        _isHonors = true;
        _gradingStrategy = new HonorsGradingStrategy();
    }

    public GradingStrategy getGradingStrategy() {
        return _gradingStrategy;
    }

    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        _gradingStrategy = gradingStrategy;
    }

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
            total += _gradingStrategy.getGradePointFor(grade);
        }
        return total / _grades.size();
    }

    public void addGrade(Grade grade) {
        _grades.add(grade);
    }
}
