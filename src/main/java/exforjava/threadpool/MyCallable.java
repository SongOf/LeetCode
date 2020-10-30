package exforjava.threadpool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {
    private int pos;
    public MyCallable(int pos){
        this.pos=pos;
    }
    @Override
    public Long call() throws Exception {
        int sum=pos*10;
        return (long)sum;
    }
}
