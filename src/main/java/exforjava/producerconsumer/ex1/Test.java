package exforjava.producerconsumer.ex1;

import exforjava.producerconsumer.ex1.Consumer;
import exforjava.producerconsumer.ex1.Producer;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        Consumer consumer1=new Consumer(queue,2,"Consumer1");
        Consumer consumer2=new Consumer(queue,2,"Consumer2");
        Consumer consumer3=new Consumer(queue,2,"Consumer3");
        Producer producer1=new Producer(queue,2,"Producer1");
        Producer producer2=new Producer(queue,2,"Producer2");
        Producer producer3=new Producer(queue,2,"Producer3");
        consumer1.start();
        consumer2.start();
        consumer3.start();
        producer1.start();
        producer2.start();
        producer3.start();
    }
}
