package IsPopOrder;

public class IsPopOrderTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-04-18 17:02
 **/
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {2, 1, 4, 3, 5};
        System.out.println(s.IsPopOrder(pushA, popA));
    }
}
