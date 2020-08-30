package sword2offer.p5;
//两种方式消耗差不多
public class Solution2 {
    public String replaceSpace(String s) {
        int sLen=s.length();
        int countSpace=0;
        for(int i=0;i<sLen;i++){
            if(s.charAt(i)==' ') {
                countSpace++;
            }
        }
        char[] res=new char[sLen+2*countSpace];
        int pos=sLen+2*countSpace-1;
        for(int i=sLen-1;i>=0;i--){
            if(s.charAt(i)==' '){
                res[pos]='0';
                pos--;
                res[pos]='2';
                pos--;
                res[pos]='%';
                pos--;
            }else {
                res[pos]=s.charAt(i);
                pos--;
            }
        }
        return new String(res);
    }
    public static void main(String[] args){
        String s="We are happy.";
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.replaceSpace(s));
    }
}
