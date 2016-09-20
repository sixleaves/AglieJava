package sis.studentinfo;
import sis.studentinfo.Student.Grade;
/**
 * Created by admini on 16/9/20.
 */
public interface GradingStrategy {
    int getGradePointFor(Grade grade);
}
