package ex5523;

public class Solution {
    public int minOperations(String[] logs) {
        if(logs==null||logs.length==0){
            return 0;
        }
        int step=0;
        for(int i=0;i<logs.length;i++){
            if(logs[i].equals("../")&&step>0){
                step--;
            }else if(logs[i].charAt(logs[i].length()-1)=='/'&&logs[i].charAt(logs[i].length()-2)!='.'){
                step++;
            }
        }
        return step;
    }
    public static void main(String[] args){
        String[] s={"d1/","../","../","../"};
        Solution solution = new Solution();
        System.out.println(solution.minOperations(s));
    }
}
