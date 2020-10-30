package sword2offer.p31;

import java.util.LinkedList;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushedLength=pushed.length;
        int poppedLength=popped.length;
        if(pushedLength==0&&poppedLength==0){
            return true;
        }
        if(popped==null||pushedLength==0||popped==null||poppedLength==0){
            return false;
        }
        int pushedPos=0;
        int poppedPos=0;
        LinkedList<Integer> stack=new LinkedList<Integer>();
        while (pushedPos<pushedLength){
            stack.push(pushed[pushedPos]);
            while (!stack.isEmpty()&&stack.peek()==popped[poppedPos]){
                stack.pop();
                poppedPos++;
            }
            pushedPos++;
        }
        if(poppedPos>=poppedLength){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args){
        int[] pushed= {1,0};
        int[] popped={1,0};
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(pushed,popped));
    }
}
