package ex1592;

public class Solution {
    public String reorderSpaces(String text) {
        if(text==null||text.length()==0){
            return "";
        }
        int wordNums=0;
        int spaceNums=0;
        StringBuffer textStr=new StringBuffer(text);
        int len=text.length();
        for(int i=0;i<len;i++){
            while(i<len&&textStr.charAt(i)==' '){
                spaceNums++;
                i++;
            }
            if(i<len&&textStr.charAt(i)>='a'&&textStr.charAt(i)<='z'){
                wordNums++;
                while(i<len&&textStr.charAt(i)>='a'&&textStr.charAt(i)<='z'){
                    i++;
                }
                i--;
            }
        }
        int avgNum;
        if(wordNums==1){
            avgNum= spaceNums;
        }else {
            avgNum=spaceNums/(wordNums-1);
        }
        StringBuffer res=new StringBuffer();
        int pos=0;
        int countWord=0;
        while (pos<len){
            while(pos<len&&textStr.charAt(pos)==' '){
                pos++;
            }
            if(pos<len&&textStr.charAt(pos)>='a'&&textStr.charAt(pos)<='z'){
                countWord++;
                while(pos<len&&textStr.charAt(pos)>='a'&&textStr.charAt(pos)<='z'){
                    res.append(textStr.charAt(pos));
                    pos++;
                }
            }
            int count=0;
            while (countWord<wordNums&&count<avgNum){
                res.append(' ');
                count++;
            }
        }
        for(int i=0;i<spaceNums-avgNum*(wordNums-1);i++){
            res.append(' ');
        }
        return new String(res);
    }
    public static void main(String[] args){
        String text="  this   is  a sentence ";
        Solution solution = new Solution();
        System.out.println(solution.reorderSpaces(text));
    }
}
