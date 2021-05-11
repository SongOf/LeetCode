package ex003;

import java.util.Scanner;

/**
 * @author SongOf
 * @ClassName Main
 * @Description
 * @Date 2021/4/27 20:11
 * @Version 1.0
 */
public class Main {
    public static class Node {
        private int left;
        private int right;
        private int c;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(main.reverseLen(nums));
    }
    public int reverseLen(int[] nums) {
        Node[] mark = new Node[nums.length];
        mark[0] = new Node();
        mark[0].left = 0;
        mark[0].right = 0;
        mark[0].c = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == 0) {
                mark[i] = new Node();
                if(mark[i - 1].c > 0) {
                    mark[i].left = mark[i - 1].left;
                }
                else
                    mark[i].left = i;
                mark[i].right = i;
                mark[i].c = mark[i - 1].c + 1;
            }
            else {
                if(mark[i - 1].c > 0) {
                    mark[i] = new Node();
                    mark[i].left = mark[i - 1].left;
                    mark[i].right = i;
                    mark[i].c = mark[i - 1].c - 1;
                }
                else {
                    mark[i] = new Node();
                    mark[i].left = i;
                    mark[i].right = i;
                    mark[i].c = 0;
                }
            }
        }
        int max = 0;
        int tarLeft = 0;
        int tarRight = 0;
        for (int i = 0; i < mark.length; i++) {
            if(mark[i].c > max) {
                max = mark[i].c;
                tarLeft = mark[i].left;
                tarRight = mark[i].right;
            }
        }
        if(tarLeft == 0 && tarRight == 0) return nums.length - 2;
        for (int i = tarLeft; i <= tarRight; i++) {
            if(nums[i] == 1) nums[i] = 0;
            else nums[i] = 1;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == 1) count ++;
        }
        return count;
    }
}
