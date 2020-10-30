package ex150;

import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null) return -1;
        if(tokens.length==0) return 0;
        LinkedList<Integer> stack=new LinkedList<>();
        int tokensLen=tokens.length;
        int num1,num2;
        for (int i = 0; i < tokensLen; i++) {
            if(tokens[i].equals("+")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2+num1);
            }else if(tokens[i].equals("-")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2-num1);
            }else if(tokens[i].equals("*")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2*num1);
            }else if(tokens[i].equals("/")){
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num2/num1);
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.isEmpty()?-1:stack.peek();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] s={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(solution.evalRPN(s));
    }
}
