package com.brianway.learning.java.concurrent.Future;


public class RealData implements Data{

    protected  String data;

    public RealData(String data) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println("data has been construct");
    }

    @Override
    public String getResult() throws InterruptedException {
        return data;
    }
}
