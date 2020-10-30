package sword2offer.p67;

public class Solution {
    public int strToInt(String str) {
        if(str==null){
            return -1;
        }
        if(str.length()==0){
            return 0;
        }
        int start=0;
        int end=0;
        char[] s=str.toCharArray();
        int len=s.length;
        while (start<len&&s[start] == ' ') {
            start++;
        }
        if(start==len){
            start--;
        }
        end=start;
        if(s[end] == '+'||s[end] == '-'){
            end++;
            if(end==len||s[end]<'0'||s[end]>'9'){
                return 0;
            }
        }
        while (end<len&&s[end]>='0'&&s[end]<='9'){
            end++;
        }
        if(end==len){
            end--;
        }
        return strToIntCore(s,start,end);
    }
    public int strToIntCore(char[] str,int start,int end) {
        boolean isPositive=true;
        if (str[start] == '+') {
            isPositive=true;
            start++;
        }else if(str[start]=='-'){
            isPositive=false;
            start++;
        }
        long res=0;
        for(int i=start;i<=end&&str[i]>='0'&&str[i]<='9';i++){
            res=res*10+(str[i]-'0');
            if(res>Integer.MAX_VALUE){
                if(isPositive==false){
                    return Integer.MIN_VALUE;
                }else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        if(isPositive==false){
            res=-res;
        }
        return (int)res;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        System.out.println(solution.strToInt("-42"));
    }
}
