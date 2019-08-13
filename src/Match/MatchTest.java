package Match;

public class MatchTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-08-13 09:02
 **/
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a", p = ".";
        char[] sa = s.toCharArray(), pa = p.toCharArray();
        System.out.println(solution.match(sa, pa));
    }
}
