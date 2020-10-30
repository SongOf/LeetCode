package exforjava.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 {
    private static final Lock lock=new ReentrantLock(false);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(ReentrantLockTest2::test,"线程"+i).start();
        }
    }
    public static void test(){
        for (int i = 0; i < 2; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获取到了锁");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName()+"释放了锁");
                lock.unlock();
            }
        }
    }
}
