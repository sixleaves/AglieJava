package sis.studentinfo;
import sis.studentinfo.Student;
/**
 * Created by admini on 16/9/20.
 */
public interface GradingStrategy {
    int getGradePointFor(Student.Grade grade);
}
