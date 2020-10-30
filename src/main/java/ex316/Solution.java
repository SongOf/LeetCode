package ex316;

import java.util.LinkedList;

public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        int sLength=s.length();
        int[] count=new int[26];
        for (int i = 0; i < sLength; i++) {
            count[s.charAt(i)-'a']++;
        }
        LinkedList<Character> stack=new LinkedList<>();
        boolean[] inStack=new boolean[26];
        char curCh;
        for (int i = 0; i < sLength; i++) {
            curCh=s.charAt(i);
            count[curCh-'a']--;
            while (!stack.isEmpty()&&!inStack[curCh-'a']&&curCh<stack.peek()&&count[stack.peek()-'a']>0){
                inStack[stack.pop()-'a']=false;
            }
            if(!inStack[curCh-'a']){
                stack.push(curCh);
                inStack[curCh-'a']=true;
            }
        }
        StringBuilder res=new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.removeDuplicateLetters("edebbed"));
    }
}
