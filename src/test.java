import GetNumberOfK.Solution;

import java.util.*;

public class test {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-04-14 21:10
 **/
    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3,4,5};
        int[] b = {1,2,3,3,3,4,5};
        Solution s = new Solution();
        System.out.println(s.GetNumberOfK(a, 3)); // 4
        System.out.println(s.GetNumberOfK(b, 3)); // 3
    }
}
