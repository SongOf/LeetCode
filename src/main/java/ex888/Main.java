package ex888;

/**
 * @author SongOf
 * @ClassName Main
 * @Description 牛顿迭代法求平方根
 * @Date 2021/4/28 1:08
 * @Version 1.0
 */
public class Main {
    double sqrt(double c, double e) {
        if (c < 0) {
            return -1;
        }

        double x = c;
        double y = (x + c / x) / 2;
        while (Math.abs(x - y) > e) {
            x = y;
            y = (x + c / x) / 2;
        }
        return x;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.sqrt(0.5, 0.00000001));
    }
}
