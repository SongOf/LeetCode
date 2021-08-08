package sword2offer.p59_1;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {
    public static class Node implements Comparable<Node> {
        private int val;
        private int index;
        private Node() {}
        private Node(int val, int index) {
            this.index = index;
            this.val = val;
        }
        @Override
        public int compareTo(Node node) {
            return this.val != node.val ? (node.val - this.val) : (node.index - this.index);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <=0 || k > nums.length) {
            return new int[0];
        }
        int length = nums.length;
        int[] res = new int[length - k + 1];
        int pos = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            queue.offer(new Node(nums[i], i));
        }
        if(!queue.isEmpty()) res[pos++] = queue.peek().val;
        for(int i = k; i < length; i++) {
            queue.offer(new Node(nums[i], i));
            while (!queue.isEmpty() && queue.peek().index <= i - k) {
                queue.poll();
            }
            if(!queue.isEmpty()) res[pos++] = queue.peek().val;
        }
        return res;
    }
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }
        int length = nums.length;
        int[] res = new int[length - k + 1];
        int pos = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            while(!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.add(i);
        }
        res[pos++] = nums[queue.getFirst()];
        for(int i = k; i < length; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.add(i);
            while(!queue.isEmpty() && queue.getFirst() <= i - k) {
                queue.removeFirst();
            }
            res[pos++]=nums[queue.getFirst()];
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums={1,3,-1,-3,5,3,6,7};
        Solution solution=new Solution();
        int[] res=solution.maxSlidingWindow1(nums,3);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}