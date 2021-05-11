package ex888;

/**
 * @author SongOf
 * @ClassName Solution
 * @Description
 * @Date 2021/4/28 1:16
 * @Version 1.0
 */
public class Solution {
    public double method(double target, double m) {
        double min,max,mid,newMid;
        min = 0;
        max = 1;
        mid = (min+max) / 2;

        do {
            if (mid*mid<target) {
                min = mid;
            } else {
                max = mid;
            }
            newMid = mid;
            mid = (max+min)/2;
        } while (Math.abs(mid - newMid) > m);

        return mid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.method(0.5, 0.00001));
    }
}
