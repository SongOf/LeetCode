package ex5546;

import java.util.Arrays;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        long[] res=new long[26];
        Arrays.fill(res,0);
        int len=keysPressed.length();
        for (int i = 0; i < len; i++) {
            int index=(keysPressed.charAt(i)-'a');
            if(i==0){
                res[index]=releaseTimes[i];
            }else {
                if(res[index]<releaseTimes[i]-releaseTimes[i-1]){
                    res[index]=(releaseTimes[i]-releaseTimes[i-1]);
                }
            }
        }
        long max=Long.MIN_VALUE;
        char tarKey=' ';
        for (int i = 0; i < 26; i++) {
            if(max<=res[i]){
                max=res[i];
                tarKey=(char)('a'+i);
            }
        }
        return tarKey;
    }

}
