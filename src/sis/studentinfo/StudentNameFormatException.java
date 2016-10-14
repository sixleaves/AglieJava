package sis.studentinfo;

/**
 * Created by admini on 16/10/14.
 */
public class StudentNameFormatException extends IllegalArgumentException {
    private String _message = null;
    public StudentNameFormatException(String message) {
        _message = message;
    }

    @Override
    public String getMessage() {
        return _message;
    }
}
