package ex509;

public class Solution {
    public int fib(int N) {
        if(N==0||N==1){
            return N;
        }
        int pre=0;
        int cur=1;
        int temp;
        for(int i=2;i<=N;i++){
            temp=cur;
            cur=pre+cur;
            pre=temp;
        }
        return cur;
    }
}
