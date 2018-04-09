package com.brianway.learning.java.concurrent.Future;

import java.util.concurrent.Callable;

/*
 *JDK自带的Future模式
 */
public class ReallyData implements Callable {
    protected  String data;

    public ReallyData(String data) {
        this.data = data;
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(10000);
        return data;
    }
}
