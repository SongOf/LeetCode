package exforjava.staticproxy;
/*
* 应用很少
* */
public class SmsProxy implements SmsService {
    private final SmsService smsService;
    public SmsProxy(SmsService smsService){
        this.smsService=smsService;
    }

    @Override
    public String send(String msg) {
        System.out.println("before send");
        smsService.send(msg);
        System.out.println("after send");
        return null;
    }

    public static void main(String[] args) {
        SmsService smsService=new SmsServiceImpl();
        SmsProxy smsProxy=new SmsProxy(smsService);
        smsProxy.send("proxy test");
    }
}
