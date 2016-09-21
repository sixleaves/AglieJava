package sis.studentinfo;
import sis.studentinfo.Student;
/**
 * Created by admini on 16/9/20.
 */
public class HonorsGradingStrategy extends BaseGradingStrategy{
    @Override
    public int getGradePointFor(Student.Grade grade) {
        int gradePoint = baseGradePointFor(grade);
        if (gradePoint > 0) gradePoint += 1;
        return gradePoint;
    }
}
