package ex5617;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2020/12/6 10:34
 * @Version 1.0
 */
public class Solution {
    public String interpret(String command) {
        char[] comstr=command.toCharArray();
        int length=command.length();
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(comstr[i]=='G'){
                res.append('G');
            }else if(comstr[i]=='/'){
                res.append("al");
            }else if(comstr[i]=='('&&comstr[i+1]==')'){
                res.append("o");
                i++;
            }else {
                res.append("al");
                i=i+3;
            }
        }
        return res.toString();
    }
}
