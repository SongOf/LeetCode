package ex347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/23 20:41
 * @Version 1.0
 */
public class Solution {
    public static  class Ele implements Comparable<Ele>{
        private int num;
        private int frequency;
        public Ele() {}
        public  Ele(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Ele o) {
            return this.frequency - o.frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counterMap.put(nums[i], counterMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Ele> qQueue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> item : counterMap.entrySet()) {
            if(qQueue.size() == k) {
                if(qQueue.peek().frequency < item.getValue()) {
                    qQueue.poll();
                    qQueue.offer(new Ele(item.getKey(), item.getValue()));
                }
            }
            else {
                qQueue.offer(new Ele(item.getKey(), item.getValue()));
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = qQueue.poll().num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,2,2,3};
        int[] res = solution.topKFrequent(nums, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
