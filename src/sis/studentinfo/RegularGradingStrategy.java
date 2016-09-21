package sis.studentinfo;

/**
 * Created by admini on 16/9/20.
 */
public class RegularGradingStrategy extends BaseGradingStrategy{
    @Override
    public int getGradePointFor(Student.Grade grade) {
        return baseGradePointFor(grade);
    }
}
