package sword2offer.p31;

import java.util.LinkedList;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || popped == null) return false;

        int pushedLength = pushed.length;
        int poppedLength = popped.length;
        if(pushedLength == 0 && poppedLength == 0) return true;
        if(pushedLength == 0 || poppedLength == 0) return false;

        LinkedList<Integer> stack = new LinkedList<>();
        int pos1 = 0;
        int pos2 = 0;
        while(pos1 < pushedLength) {
            stack.push(pushed[pos1]);
            while(!stack.isEmpty() && stack.peek() == popped[pos2]) {
                stack.pop();
                pos2 ++;
            }
            pos1 ++;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        int[] pushed= {1,0};
        int[] popped={1,0};
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(pushed,popped));
    }
}
