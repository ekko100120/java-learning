package com.kenny.Thread.AtomicDemo;

public class ThreadTest {

    public static void main(String[] args) {
        AtomicDemo demo = new AtomicDemo();
        for (int i = 0; i < 10 ; i++) {
            new Thread(demo).start();
        }
    }
}
