package exforjava.threadpool;

import java.util.Date;

public class MyThread extends Thread {
    private String name;
    public MyThread(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date()+"继承Thread的任务");
        processCommand();
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
    }
    private void processCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
