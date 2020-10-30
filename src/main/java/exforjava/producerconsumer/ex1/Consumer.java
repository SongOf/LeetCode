package exforjava.producerconsumer.ex1;

import java.util.Queue;

public class Consumer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;
    public Consumer(Queue<Integer> queue,int maxSize,String name){
        this.queue=queue;
        this.maxSize=maxSize;
        this.setName(name);
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                System.out.println(this.getName()+"获得队列的锁");
                while (queue.size()==0){
                    System.out.println("队列为空");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int con=queue.poll();
                System.out.println(this.getName()+"消费了"+con);
                queue.notifyAll();
            }
        }
    }
}
