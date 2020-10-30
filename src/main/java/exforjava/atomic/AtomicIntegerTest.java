package exforjava.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private AtomicInteger count=new AtomicInteger();
    public void increment(){
        count.incrementAndGet();
    }
    public int getCount(){
        return count.get();
    }

    public static void main(String[] args) {
        AtomicIntegerTest atomicIntegerTest=new AtomicIntegerTest();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                atomicIntegerTest.increment();
                System.out.println(atomicIntegerTest.getCount());
            }).start();
        }
    }
}
