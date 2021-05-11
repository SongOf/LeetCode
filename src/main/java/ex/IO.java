package ex;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author SongOf
 * @ClassName IO
 * @Description
 * @Date 2021/3/9 21:55
 * @Version 1.0
 */
public class IO {
    public static void main(String[] args) {
        /*------------------Scanner类-------------------*/
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        System.out.println(n1 + n2);

        String s = scanner.next();
        System.out.println(s);
        scanner.nextLine();

        String s1 = scanner.nextLine();
        System.out.println(s1);
        /*----------------------------------------------*/
        double d = 0.200;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(d));
    }
}
