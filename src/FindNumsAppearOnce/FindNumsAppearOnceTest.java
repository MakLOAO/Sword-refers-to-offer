package FindNumsAppearOnce;

public class FindNumsAppearOnceTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-07-16 15:45
 **/

    public static void main(String... args) {
        int[] ar = {2,4,3,6,3,2,5,5};
        int[] a = {0};
        int[] b = {0};
        Solution s = new Solution();
        s.FindNumsAppearOnce(ar, a, b);
        System.out.println(a[0] + " " + b[0]);
    }
}
