package com.brianway.learning.java.base.constructor;


/*
*
* 由输出结果可知，执行顺序为：
*  static静态代码块和静态成员
*  普通成员，普通块
*  构造函数执行
*  当具有多个静态成员和静态代码块或者多个普通成员时，初始化顺序和成员在程序中申明的顺序一致。
*
*  注意到在该程序的静态代码块中，修改了静态成员sam的引用。
*  main()方法中创建了2个主类对象，但是由输出结果可知，静态成员和静态代码块只进行了一次初始化，并且新建的2个主类对象的静态成员sam.s是相同的。
*  由此可知，类的静态成员和静态代码块在类加载中是最先进行初始化的，并且只进行一次。
*  该类的多个实例共享静态成员，静态成员的引用指向程序最后所赋予的引用。
*/

public class InitialOrderWithoutExtend {
    static SampleClass sam = new SampleClass("静态成员sam初始化");
    SampleClass sam1 = new SampleClass("普通成员sam1初始化");
    static {
        System.out.println("static块执行");
        if (sam == null)
            System.out.println("sam is null");
        sam = new SampleClass("静态块内初始化sam成员变量");
    }
    {
        System.out.println("普通块执行");
    }

    SampleClass sam2 = new SampleClass("普通成员sam2初始化");

    InitialOrderWithoutExtend() {
        System.out.println("InitialOrderWithoutExtend默认构造函数被调用");
    }

    public static void main(String[] args) {
        // 创建第1个主类对象
        System.out.println("第1个主类对象：");
        InitialOrderWithoutExtend ts = new InitialOrderWithoutExtend();

        // 创建第2个主类对象
        System.out.println("第2个主类对象：");
        InitialOrderWithoutExtend ts2 = new InitialOrderWithoutExtend();

        // 查看两个主类对象的静态成员：
        System.out.println("2个主类对象的静态对象：");
        System.out.println("第1个主类对象, 静态成员sam.s: " + ts.sam);
        System.out.println("第2个主类对象, 静态成员sam.s: " + ts2.sam);
    }
}

class SampleClass {
    // SampleClass 不能包含任何主类InitialOrderWithoutExtend的成员变量
    // 否则导致循环引用，循环初始化，调用栈深度过大
    // 抛出 StackOverFlow 异常
    // static InitialOrderWithoutExtend iniClass1 = new InitialOrderWithoutExtend("静态成员iniClass1初始化");
    // InitialOrderWithoutExtend iniClass2 = new InitialOrderWithoutExtend("普通成员成员iniClass2初始化");

    String s;

    SampleClass(String s) {
        this.s = s;
        System.out.println(s);
    }

    SampleClass() {
        System.out.println("SampleClass默认构造函数被调用");
    }

    @Override
    public String toString() {
        return this.s;
    }
}


//        静态成员sam初始化
//        static块执行
//        静态块内初始化sam成员变量
//        第1个主类对象：
//        普通成员sam1初始化
//        普通块执行
//        普通成员sam2初始化
//        InitialOrderWithoutExtend默认构造函数被调用
//        第2个主类对象：
//        普通成员sam1初始化
//        普通块执行
//        普通成员sam2初始化
//        InitialOrderWithoutExtend默认构造函数被调用
//        2个主类对象的静态对象：
//        第1个主类对象, 静态成员sam.s: 静态块内初始化sam成员变量
//        第2个主类对象, 静态成员sam.s: 静态块内初始化sam成员变量