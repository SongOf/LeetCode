package sword2offer.p58_1;

public class Solution {
    public String reverseWords(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        int length=s.length();
        int startIndex=0;
        int endIndex=length-1;
        char[] str=s.toCharArray();
        reverse(str,startIndex,endIndex);
        endIndex=startIndex;
        while (startIndex<length){
            if(str[startIndex]==' '){
                startIndex++;
                endIndex++;
            }
            while (endIndex<length&&str[endIndex]!=' '){
                endIndex++;
            }
            endIndex--;
            reverse(str,startIndex,endIndex);
            endIndex++;
            startIndex=endIndex;
        }
        return filterSpace(str,length);
    }
    public String filterSpace(char[] str,int length){
        StringBuilder res=new StringBuilder();
        int pos=0;
        int end=length-1;
        while (pos<=end&&str[pos]==' '){
            pos++;
        }
        while (pos<=end&&str[end]==' '){
            end--;
        }
        for(int i=pos;i<=end;i++){
            if(str[i]==' '){
                while (i<=end&&str[i]==' '){
                    i++;
                }
                res.append(' ');
            }
            res.append(str[i]);
        }
        return new String(res);
    }
    public void reverse(char[] s,int start,int end){
        if(start<0||end<0){
            return;
        }
        char ch;
        while (start<end){
            ch=s[start];
            s[start]=s[end];
            s[end]=ch;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        String s="the sky is blue";
        Solution solution=new Solution();
        System.out.println(solution.reverseWords(s));
    }
}
