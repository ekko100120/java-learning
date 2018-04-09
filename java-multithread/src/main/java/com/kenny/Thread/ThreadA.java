package com.kenny.Thread;

import javafx.event.Event;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadA extends Thread {
    private List<? extends Object> list;
    @Override
    public void run() {
        System.out.println("ThreadA is running");
        int i=1;
        while (true) {

            if (this.isInterrupted()){
                System.out.println(currentThread().getName()+" isInterrupted, should be exit");
                break;
            }else {
                System.out.println("i ="+(i++));
            }
        }
        System.out.println("Thread is executed, Thread does not stopped");
    }
}
