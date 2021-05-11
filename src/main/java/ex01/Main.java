package ex01;

import java.util.Scanner;

/**
 * @author SongOf
 * @ClassName Main
 * @Description
 * @Date 2021/4/24 20:01
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        if(n == 1 || n == 2) {
            System.out.println(1);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 3] + dp[i - 1]) % 998244353;
        }
        System.out.println(dp[n]);
    }
}