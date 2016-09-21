package sis.studentinfo;

/**
 * Created by admini on 16/9/20.
 */
public class RegularGradingStrategy implements GradingStrategy {
    @Override
    public int getGradePointFor(Student.Grade grade) {
        switch (grade) {
            case A: return 4;
            case B: return 3;
            case C: return 2;
            case D: return 1;
            default: return 0;
        }
    }
}
