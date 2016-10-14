package sis.studentinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sixleaves on 16/8/11.
 */
public class Student {

    private String _firstName = "";
    private String _middleName = "";
    private String _lastName;

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

    public String getFirstName() {
        return _firstName;
    }

    public String getMiddleName() {
        return _middleName;
    }

    public String getLastName() {
        return _lastName;
    }

    public enum Grade {
        A(4),
        B(3),
        C(2),
        D(1),
        F(0);
        private int _points;
        Grade(int points) {
            _points = points;
        }

        public int getPoints() {
            return _points;
        }

    }

    private String _state = "";
    private double _gpa = 0;
    private ArrayList<Grade> _grades = new ArrayList<Grade>();

    private String _name;

    private int _credits;
    private int _maxNumberofNameParts = 4;
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";

    public Student(String name) {
        _name = name;
        List<String> nameParts = _split(name);
        // 非检查异常, 所以方法不用抛出异常
        if (nameParts.size() >= _maxNumberofNameParts) throw new StudentNameFormatException();
        setName(nameParts);

    }

    // 替代List<String> nameParts = Arrays.asList(name.split(" "));
    // 因为asList只是给数组提供一种集合的视图,本身操作的还是数组。所以如果要删除操作是无法进行的。
    private List<String> _split(String name) {
        List<String> results = new ArrayList<String>();
        for (String namePart: name.split(" ")) {
            results.add(namePart);
        }
        return results;
    }

    private void setName(List<String> nameParts) {
        _lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty()) {
            _firstName = name;
        }else  {
            _firstName = removeLast(nameParts);
            _middleName = name;
        }
    }

    private String removeLast(List<String> list) {
        if (list.isEmpty()) return "";
        return list.remove(list.size() - 1);
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
