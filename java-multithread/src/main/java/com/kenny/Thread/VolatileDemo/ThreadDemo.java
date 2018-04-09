package com.kenny.Thread.VolatileDemo;

public class ThreadDemo implements Runnable {
    private  boolean flag =false;
    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag =true;
        System.out.println("flag = "+isFlag());
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean isFlag(){
        return  flag;
    }
}
