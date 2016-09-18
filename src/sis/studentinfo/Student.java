package sis.studentinfo;

/**
 * Created by sixleaves on 16/8/11.
 */
public class Student {

    private String _name;

    private int _credits;

    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;

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
}
