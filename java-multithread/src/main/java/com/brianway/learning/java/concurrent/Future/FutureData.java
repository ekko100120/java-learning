package com.brianway.learning.java.concurrent.Future;

import com.brianway.learning.java.concurrent.LiftOff;

public class FutureData implements  Data {

    private  RealData realData =null;
    private  boolean isReady =false;

    public synchronized void setRealData(RealData realData) {
       if (isReady){
           return;
       }
       this.realData=realData;
       isReady=true;
       notifyAll();
       this.realData = realData;
    }

    @Override
    public synchronized  String getResult() throws InterruptedException {
        if (!isReady){
            wait();
        }
        return  realData.getResult();
    }
}
