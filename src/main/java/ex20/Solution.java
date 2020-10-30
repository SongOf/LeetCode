package ex20;

import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        if(s==null) return false;
        if(s.length()==0) return true;
        LinkedList<Character> stack=new LinkedList<>();
        for(char ch:s.toCharArray()){
            if(ch=='(') stack.push(')');
            else if(ch=='[') stack.push(']');
            else if(ch=='{') stack.push('}');
            else if(stack.isEmpty()||ch!=stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isValid("{[]}"));
    }
}