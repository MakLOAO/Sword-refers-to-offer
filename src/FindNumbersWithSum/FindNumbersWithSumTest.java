package FindNumbersWithSum;

import java.util.ArrayList;

public class FindNumbersWithSumTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-07-17 17:40
 **/
    public static void main(String[] args) {
        int[] ints = {1,2,4,7,11,15};
        Solution s = new Solution();
        ArrayList<Integer> list = s.FindNumbersWithSum(ints, 15);
        list.forEach(element -> System.out.println(element));
        int[] ints1 = {};
        s.FindNumbersWithSum(ints1, 0);
    }
}
