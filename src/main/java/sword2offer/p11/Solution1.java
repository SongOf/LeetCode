package sword2offer.p11;

/**
 * @author SongOf
 * @ClassName Solution1
 * @Description
 * @Date 2021/4/16 11:37
 * @Version 1.0
 */
public class Solution1 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(numbers[mid] > numbers[right]) left = mid + 1;
            else if(numbers[mid] < numbers[right]) right = mid;
            else right --;
        }
        return numbers[left];
    }
}
