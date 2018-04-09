package com.kenny.Thread.AtomicDemo;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo implements Runnable {
    private AtomicInteger number = new AtomicInteger();
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+" : "+getNumber());
    }

    public int getNumber() {
        return number.getAndIncrement();
    }
}
