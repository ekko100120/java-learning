package com.brianway.learning.java.base.constructor;
/*
* 执行顺序：
* 1. 父类  >子类
* 2. 同类间: 同优先级按代码先后顺序;
*   静态块, 静态类变量, 最高优先级
*   普通块和普通成员,  次优先级
*   构造函数   次次优先级
*   对象方法   最低优先级
* 3.子类初始化时，会首先调用父类的无参构造函数(无论是否有super())，然后子类的构造函数
*/
public class InitialOrderWithExtend {
    public static void main(String[] args) {
//        Father father = new Son();
         Father father = new Son(1000000);

    }
}

class Father {
    {
        System.out.println("父类 非静态块 1  执行");
    }
    static {
        System.out.println("父类 static块 1  执行");
    }
    static Sample staticSam1 = new Sample("父类 静态成员 staticSam1 初始化");
    Sample sam1 = new Sample("父类 普通成员 sam1 初始化");
    static Sample staticSam2 = new Sample("父类 静态成员 staticSam2 初始化");
    static {
        System.out.println("父类 static块 2  执行");
    }

    Father() {
        System.out.println("父类 默认构造函数被调用");
    }
    {
        System.out.println("父类 普通块被调用");
    }

    Sample sam2 = new Sample("父类 普通成员 sam2 初始化");

    {
        System.out.println("父类 非静态块 2  执行");
    }

}

class Son extends Father {
    {
        System.out.println("子类 非静态块 1  执行");
    }
    private  int number=100;
    static Sample staticSamSub1 = new Sample("子类 静态成员 staticSamSub1 初始化");

    Son() {
        System.out.println("子类无参数构造函数"+number);
        System.out.println("子类 默认构造函数被调用");
    }

    public Son(int number) {
        System.out.println("子类有参数构造函数"+number);  //此方法的number值是在构造函数初始化以后执行的
        this.number = number;
        System.out.println("子类有参数构造函数"+number);

    }
    Sample sam1 = new Sample("子类 普通成员 sam1 初始化");
    static Sample staticSamSub2 = new Sample("子类 静态成员 staticSamSub2 初始化");

    static {
        System.out.println("子类 static块1  执行");
    }

    Sample sam2 = new Sample("子类 普通成员 sam2 初始化");

    {
        System.out.println("子类 非静态块 2  执行");
    }

    static {
        System.out.println("子类 static块2  执行");
    }
}

class Sample {
    Sample(String s) {
        System.out.println(s);
    }

    Sample() {
        System.out.println("Sample默认构造函数被调用");
    }
}
