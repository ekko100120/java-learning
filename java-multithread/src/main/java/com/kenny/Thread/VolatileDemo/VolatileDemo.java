package com.kenny.Thread.VolatileDemo;

public class VolatileDemo {
    public static void main(String[] args){
        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();
        while(true){
            if (demo.isFlag()){
                System.out.println("+++++++++");
                break;
            }
        }
    }
}
