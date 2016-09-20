package sis.studentinfo;

/**
 * Created by admini on 16/9/20.
 */
public class RegularGradingStrategy implements GradingStrategy {
    @Override
    public int getGradePointFor(Student.Grade grade) {
        if (grade.equals(Student.Grade.A)) return  4;
        if (grade.equals(Student.Grade.B)) return  3;
        if (grade.equals(Student.Grade.C)) return  2;
        if (grade.equals(Student.Grade.D))  return  1;
        return 0;

    }
}
