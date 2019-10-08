package IsNumeric;

public class IsNumericTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-08-13 09:41
 **/
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "a.2";
        char[] chars = str.toCharArray();
        System.out.println(s.isNumeric(chars));
    }
}
