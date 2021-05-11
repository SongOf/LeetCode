package ex5694;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongOf
 * @ClassName AuthenticationManager
 * @Description
 * @Date 2021/3/20 22:49
 * @Version 1.0
 */
public class AuthenticationManager {
    public static class Code {
        private String tokenId;
        private int expireTime;
        public Code(){}
        public Code(String tokenId, int expireTime){
            this.tokenId = tokenId;
            this.expireTime = expireTime;
        }
    }
    private int timeToLive;
    private Map<String, Code> codes;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        codes = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        codes.put(tokenId, new Code(tokenId, currentTime + timeToLive));
    }

    public void renew(String tokenId, int currentTime) {
        if(codes.containsKey(tokenId) && codes.get(tokenId).expireTime > currentTime) {
            codes.get(tokenId).expireTime = currentTime + timeToLive;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Map.Entry<String, Code> code : codes.entrySet()) {
            if(code.getValue().expireTime > currentTime) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AuthenticationManager obj = new AuthenticationManager(5);
        obj.renew("aaaa", 1);
        obj.generate("aaaa", 2);
        System.out.println(obj.countUnexpiredTokens(6));
        obj.generate("bbb", 7);
        obj.renew("aaa", 8);
        obj.renew("bbb", 10);
        System.out.println(obj.countUnexpiredTokens(15));
    }
}
