package sis.report;

import sis.studentinfo.Student;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by admini on 16/9/21.
 */
public class ReportCard {

    private Map<Student.Grade, String> _message = null;

    public static final String A_MESSAGE = "Excellent";

    public static final String B_MESSAGE = "Very good";
    public static final String C_MESSAGE = "Hmmm....";
    public static final String D_MESSAGE = "You're not trying";
    public static final String F_MESSAGE = "Loser";

    // lazy loading
    public String getMessage(Student.Grade grade) {
        if (_message == null) {
            _message =new EnumMap<Student.Grade, String>(Student.Grade.class);
            _message.put(Student.Grade.A, A_MESSAGE);
            _message.put(Student.Grade.B, B_MESSAGE);
            _message.put(Student.Grade.C, C_MESSAGE);
            _message.put(Student.Grade.D, D_MESSAGE);
            _message.put(Student.Grade.F, F_MESSAGE);
        }
        return _message.get(grade);
    }
}
