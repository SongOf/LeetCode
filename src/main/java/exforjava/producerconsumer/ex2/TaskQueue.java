package exforjava.producerconsumer.ex2;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    private Queue<String> queue=new LinkedList<>();
    private final int MAX=6;
    public synchronized boolean addTask(String taskName){
        while (queue.size()>=MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(taskName);
        System.out.println("Producer"+Thread.currentThread().getName()+"-task"+taskName);
        this.notifyAll();
        return true;
    }
    public synchronized String getTask(){
        while (queue.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String s=queue.remove();
        System.out.println("Consumer"+Thread.currentThread().getName()+"-task"+s);
        this.notifyAll();
        return s;
    }

    public static void main(String[] args) {
        TaskQueue taskQueue=new TaskQueue();
        new Thread(()->{
            int i=0;
            while (true){
                taskQueue.addTask(""+i);
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            int i=0;
            while (true){
                taskQueue.addTask(""+i);
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            while (true){
                taskQueue.getTask();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
