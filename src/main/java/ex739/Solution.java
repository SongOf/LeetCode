package ex739;

import java.util.LinkedList;

public class Solution {

    public int[] dailyTemperatures(int[] T) {
        int len=T.length;
        int[] res=new int[len];
        LinkedList<Integer> stack=new LinkedList<>();
        for (int i = len-1; i >= 0; i--) {
            while (!stack.isEmpty()&&T[stack.peek()]<=T[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] T={73, 74, 75, 71, 69, 72, 76, 73};
        int[] res=solution.dailyTemperatures(T);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
