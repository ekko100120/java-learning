package com.brianway.learning.java.concurrent.Future;

/*
 * Future模式实现原理(主要目的:去除了主函数的等待时间，并使得原本需要等待的时间段可以用于处理其他业务逻辑)
 *  https://www.cnblogs.com/winkey4986/p/6203225.html
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        Data data =client.request("kenny");
        Thread.sleep(2000);
        System.out.println("数据="+ data.getResult());
    }
}
