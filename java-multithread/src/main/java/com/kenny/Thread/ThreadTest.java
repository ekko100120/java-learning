package com.kenny.Thread;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        new ThreadTest().start();
    }
    public void start() throws InterruptedException {

//        1.继承Thread类

        try{
            Thread thread1 = new ThreadA();
            thread1.start();
            Thread.sleep(1000);
            thread1.interrupt();
        }catch (InterruptedException e){
            System.out.println("end");
        }

//        2. 直接创建匿名内部类
         Thread thread2 = new Thread(){
            @Override
            public void run() {
                System.out.println("Thread2 is start");
            }
        };
        thread2.start();
//        3.实现runnable接口，并 new Thread(Runnable runnable)
        Thread thread3 = new Thread(new ThreadB());
        thread3.start();
    }
}
