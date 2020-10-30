package exx;

public class Test {
    public static class Counter {
        public static final Object lock=new Object();
        public static int count = 0;
    }
    public static class AddThread extends Thread {
        public void run() {
            for (int i=0; i<10000; i++) {
                synchronized (Counter.lock){
                    Counter.count += 1;
                }
            }
        }
    }
    public static class DecThread extends Thread {
        public void run() {
            for (int i=0; i<10000; i++) {
                synchronized (Counter.lock){
                    Counter.count -= 1;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }
}
