package com.kenny.Thread.BlockMethod;

import org.junit.Test;
/*
*join —— 让一个线程等待另一个线程完成才继续执行。
        如A线程执行体中调用B线程的join()方法，则A线程被阻塞，直到B线程执行完为止，A才能得以继续执行。
 */
public class ThreadA {
    @Test
    public  void test() throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable,"countThread");
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
            if (i==50){

                thread.start();
                Thread.sleep(100);
                Thread.interrupted();
                thread.interrupt();
                thread.isInterrupted();
                try {
                    //main线程阻塞，直到countThread执行完
                    thread.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    class MyRunnable implements  Runnable{

        @Override
        public void run() {
            for (int i = 0; i <200 ; i++) {
                System.out.println(Thread.currentThread().getName()+":"+ i);
            }
        }
    }
}
