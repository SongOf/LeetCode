package ex8;
//long也会溢出
public class Solution {
    public int myAtoi(String str) {
        int strLength=str.length();
        char flag='#';

        int i=0;
        while (i<strLength && str.charAt(i)==' '){
            i++;
        }
        if(i<strLength && (str.charAt(i)=='-' || str.charAt(i)=='+')){
            flag=str.charAt(i);
            i++;
        }
        long res=0;
        int valueTemp=0;
        int charValue0=(int)('0');
        int charValue9=(int)('9');
        while (i<strLength && (int)str.charAt(i)>=charValue0 && (int)str.charAt(i)<=charValue9){
            valueTemp=(int)str.charAt(i);
            res=res*10+valueTemp-charValue0;
            if(flag=='-' && -res<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else if(flag!='-' && res>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            i++;
        }
        if(flag=='-'){
            return (int) -res;
        }
        return (int) res;
    }
    public static void main(String[] args){
        String str="-2147483648";
        System.out.println(Long.MAX_VALUE);
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(str));
    }
}
