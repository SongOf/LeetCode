package ex002;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author SongOf
 * @ClassName Main
 * @Description
 * @Date 2021/4/27 19:46
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        BigInteger bi = new BigInteger(scanner.nextLine());
        int k = scanner.nextInt();
        main.minBitN(bi, k);
    }
    public void minBitN(BigInteger bi, int k) {
        bi.add(new BigInteger("1"));
        while (true) {
            int count = 0;
            for (int i = 0; i < bi.bitLength(); i++) {
                if(bi.testBit(1)) {
                    count ++;
                }
            }
            if (count == k) {
                System.out.println(bi);
                break;
            }
        }
    }
}
