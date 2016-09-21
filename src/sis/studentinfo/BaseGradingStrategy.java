package sis.studentinfo;

/**
 * Created by admini on 16/9/21.
 */
abstract public class BaseGradingStrategy implements GradingStrategy{
    abstract public int getGradePointFor(Student.Grade grade);

    public int baseGradePointFor(Student.Grade grade) {
        return grade.getPoints();
    }
}
