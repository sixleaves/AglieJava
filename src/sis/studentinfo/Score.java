package sis.studentinfo;

/**
 * Created by admini on 16/10/14.
 */
public class Score {
    public int score(String s) {
        return Integer.parseInt(s);
    }

    public boolean isValid(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}
