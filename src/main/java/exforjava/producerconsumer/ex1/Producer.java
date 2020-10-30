package exforjava.producerconsumer.ex1;

import java.util.Queue;

public class Producer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;
    public Producer(Queue<Integer> queue,int maxSize,String name){
        this.queue=queue;
        this.maxSize=maxSize;
        this.setName(name);
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                System.out.println(this.getName()+"获得队列的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (queue.size()==maxSize){
                    System.out.println("队列已经满了");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int pro=(int)(Math.random()*100);
                queue.add(pro);
                System.out.println(this.getName()+"生产一个元素"+pro);
                queue.notifyAll();
            }
        }
    }
}
