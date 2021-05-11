package ex00;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SongOf
 * @ClassName Main
 * @Description
 * @Date 2021/4/24 18:43
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[] counter = new int[m + 1];
        Arrays.fill(counter, 0);
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            counter[tmp] ++;
        }
        int index = 0;
        int max = 0;
        for (int i = 1; i <= m; i++) {
            if(counter[i] > max) {
                max = counter[i];
                index = i;
            }
        }
        System.out.print(index + " " + max);
        char ch = 87;
        char ch1 = 'a';
        System.out.println("xc" + ch);
        System.out.println("xc" + ch1);
    }
}
