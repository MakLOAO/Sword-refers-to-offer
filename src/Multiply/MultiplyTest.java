package Multiply;

public class MultiplyTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-08-12 16:34
 **/
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        Solution s = new Solution();
        int[] B = s.multiply(A);
        for (int i : B) System.out.println(i);
    }
}
