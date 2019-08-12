package Duplicate;

public class DuplicateTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-08-12 10:10
 **/
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] param1 = {2,1,3,4,0};
        int[] param3 = new int[1];
        System.out.println(s.duplicate(param1, param1.length, param3));
    }

}
