package sis.studentinfo;

/**
 * Created by sixleaves on 16/8/11.
 */
// press alt+enter 根据智能提示补全所要的框架
//    import junit.textui.TestRunner
// java -cp .:/Users/sixleaves/.m2/repository/junit/junit/4.12/junit-4.12.jar junit.textui.TestRunner StudentTest
// java -cp .:/Users/sixleaves/.m2/repository/junit/junit/4.12/junit-4.12.jar junit.textui.ResultPrinter StudentTest
public class StudentTest extends junit.framework.TestCase {
    public void testCreate() {
        // 请重构代码, 并说明原因
        Student firstStudent = new Student("SuWeiPeng");
        assertEquals(firstStudent.getName(), "SuWeiPeng");

        Student secondStudent = new Student("WangDongLiang");
        assertEquals(secondStudent.getName(), "WangDongLiang");
    }
}
/*
* 该段代码违背了系统中的代码不要有重复的代码.重复的代码容易带来两个问题.
* 1.维护的困难, 如果改变其中一个, 也要去改另一个
* 2.如果重复的代码, 你改变了其中一个,容易造成漏改,从而代码引入了缺陷, 系统不稳定.
* 主要是重复出现的字符串最好定义成字符串常量.
* 主要语法是用final修饰, 在java中, final修饰的变量是不可变量的两,即引用的变量不给变, 而不是被引用的不给变.
* 类似与C中的char * const p;表示p不可变.final即是这个意思.
* 详细代码参照StudentTest1
* */
