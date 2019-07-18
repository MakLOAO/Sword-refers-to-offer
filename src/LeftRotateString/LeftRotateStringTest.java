package LeftRotateString;

public class LeftRotateStringTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-07-18 10:38
 **/
    public static void main(String... args) {
        Solution s = new Solution();
        String ans = s.LeftRotateString("abcXYZdef", 3);
        System.out.println(ans);
        System.out.println(s.LeftRotateString("", 3));
        System.out.println(s.LeftRotateString("abc", 10));
    }
}
