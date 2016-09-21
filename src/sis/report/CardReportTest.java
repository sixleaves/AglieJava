package sis.report;

import junit.framework.TestCase;
import sis.studentinfo.Student;

/**
 * Created by admini on 16/9/21.
 */
public class CardReportTest extends TestCase {

    // 测试根据成绩等级所获取的量化信息
    public void testGradeMessage() {
        ReportCard card = new ReportCard();
        assertEquals(ReportCard.A_MESSAGE, card.getMessage(Student.Grade.A));
        assertEquals(ReportCard.B_MESSAGE, card.getMessage(Student.Grade.B));
        assertEquals(ReportCard.C_MESSAGE, card.getMessage(Student.Grade.C));
        assertEquals(ReportCard.D_MESSAGE, card.getMessage(Student.Grade.D));
        assertEquals(ReportCard.F_MESSAGE, card.getMessage(Student.Grade.F));

    }

}
