package exforjava.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class IOClient {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                try{
                    Socket socket=new Socket("127.0.0.1",3332);
                    while (true){
                        try {
                            socket.getOutputStream().write((new Date()+"---hello").getBytes());
                            Thread.sleep(2000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
