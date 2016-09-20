package sis.studentinfo;
import sis.studentinfo.Student.Grade;
/**
 * Created by admini on 16/9/20.
 */
public class HonorsGradingStrategy implements GradingStrategy{
    @Override
    public int getGradePointFor(Grade grade) {
        int gradePoint = baseGradePointFor(grade);
        if (gradePoint > 0) gradePoint += 1;
        return gradePoint;
    }

    public int baseGradePointFor(Grade grade) {
        if (grade.equals(Grade.A)) return  4;
        if (grade.equals(Grade.B)) return  3;
        if (grade.equals(Grade.C)) return  2;
        if (grade.equals(Grade.D))  return  1;
        return 0;
    }
}
