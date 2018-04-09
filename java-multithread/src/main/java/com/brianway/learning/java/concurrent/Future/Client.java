package com.brianway.learning.java.concurrent.Future;

public class Client {

    public Data request(final String str){
        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(str);
                futureData.setRealData(realData);
            }
        }).start();
        return  futureData;
    }
}
