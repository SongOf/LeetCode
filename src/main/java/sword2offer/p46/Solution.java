package sword2offer.p46;

public class Solution {
    public int translateNum(int num) {
        return translateNumCore(num);
    }

    public int translateNumCore(int num) {
        if(num >= 0 && num <= 9) return 1;
        int tmp = num % 100;
        if(tmp > 9 && tmp < 26) return translateNumCore(num / 10) + translateNumCore(num / 100);
        else return translateNumCore(num / 10);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));
    }
}
