package exforjava.singletonbystaticclass;

public class Singleton {
    private String name;
    private String tag;
    private Long createTime;

    private Singleton(){
        this.name="Singleton-a";
        this.tag="Test-Singleton";
        this.createTime=System.currentTimeMillis();
    }

    private static class SingletonHolder{
        private static final Singleton INSTANCE=new Singleton();
    }

    private static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton singleton=Singleton.getInstance();
                    System.out.println("hashcode:"+singleton.hashCode());
                    System.out.println(singleton.toString());
                }
            }).start();
        }
    }
}
