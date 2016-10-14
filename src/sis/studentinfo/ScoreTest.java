package sis.studentinfo;

import junit.framework.TestCase;

/**
 * Created by admini on 16/10/14.
 */
public class ScoreTest extends TestCase {
    public void testCaptureScore() {
        Score score = new Score();
        assertEquals(75, score.score("75"));
    }

    // 无效的输入。会抛出异常
    // 验证条件是执行fail方法说明没有异常, 程序会终止
    // 而跳转到catch则什么都没有执行。
    public void testBadInput() {
        Score score = new Score();
        try {
            score.score("abcd");
            fail("expected NumberFormat Exception on bat input");
        }catch (NumberFormatException success) {

        }
    }

    // 异常处理
    public void testValid() {
        Score score = new Score();
        assertTrue(score.isValid("75"));
        assertFalse(score.isValid("abcd"));
    }


}
