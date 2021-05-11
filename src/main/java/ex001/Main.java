package ex001;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SongOf
 * @ClassName Main
 * @Description
 * @Date 2021/4/27 19:11
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            long n = scanner.nextLong();
            main.reRecord(n);
        }
    }
    public void reRecord(long n) {
        int[] bitN = new int[50];
        Arrays.fill(bitN, 0);
        int pos = 49;
        while (pos >= 0 && n != 0) {
            bitN[pos] = (int) (n % 2);
            n = n / 2;
            pos --;
        }
        System.out.println(49 - pos);
        int day = 0;
        for (int i = pos + 1; i < 50; i++) {
            day ++;
            if(bitN[i] == 1) {
                System.out.print(day + " ");
            }
        }
        System.out.println();
    }
}
