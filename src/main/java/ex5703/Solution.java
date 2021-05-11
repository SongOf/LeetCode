package ex5703;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/3/14 11:03
 * @Version 1.0
 */
public class Solution {
    public static class Class implements Comparable<Class> {
        private int pass;
        private int total;
        //当前的通过率值 pass/total
        private double oldPt;
        //+1后的通过率值 (pass + 1)/(total + 1)
        private double newPt;
        //+1后的通过率增值 newPt - oldPt
        private double m;
        public Class() {}
        public Class(int pass, int total, double m, double newPt, double oldPt) {
            this.pass = pass;
            this.total = total;
            this.m = m;
            this.newPt = newPt;
            this.oldPt = oldPt;
        }

        @Override
        public int compareTo(Class o) {
            if(this.m > o.m) return -1;
            else if(this.m == o.m) return 0;
            return 1;
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Class> queue = new PriorityQueue<>();
        for (int i = 0; i < classes.length; i++) {
            double oldPt = (double) classes[i][0]/classes[i][1];
            double newPt = (double) (classes[i][0] + 1)/(classes[i][1] + 1);
            queue.offer(new Class(classes[i][0] + 1, classes[i][1]  + 1, newPt - oldPt, newPt, oldPt));
        }
        while (extraStudents > 0) {
            Class maxClass = queue.poll();
            double newPt = (double) (maxClass.pass + 1)/(maxClass.total + 1);
            queue.offer(new Class(maxClass.pass + 1, maxClass.total + 1, newPt - maxClass.newPt, newPt, maxClass.newPt));
            extraStudents--;
        }
        double res = 0.0;
        while (!queue.isEmpty()) {
            res += queue.poll().oldPt;
        }
        return res/classes.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] classes = {
                {2,4},
                {3,9},
                {4,5},
                {2,10}
        };
        System.out.println(solution.maxAverageRatio(classes, 4));
    }
}
