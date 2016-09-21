package sis.studentinfo;

/**
 * Created by admini on 16/9/21.
 */
public class BaseGradingStrategy {
    public int baseGradePointFor(Student.Grade grade) {
        switch (grade) {
            case A: return 4;
            case B: return 3;
            case C: return 2;
            case D: return 1;
            default: return 0;
        }
    }
}
