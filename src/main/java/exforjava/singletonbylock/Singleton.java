package exforjava.singletonbylock;
//双重校验锁实现对象单例-线程安全
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton(){
    }

    public static Singleton getSingleton() {
        if(uniqueInstance==null){
            synchronized (Singleton.class){
                if(uniqueInstance==null){
                    uniqueInstance= new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println(Singleton.getSingleton().hashCode());
            }).start();
        }
    }
}
