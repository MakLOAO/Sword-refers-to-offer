package NumberOf1;

import java.util.Scanner;

public class NumberOf1Test {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-04-15 10:34
 **/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int target;
        while ((target = scanner.nextInt()) != 0) {
            String t = Integer.toBinaryString(target);
            System.out.println(t);
            System.out.println(solution.NumberOf1(target));
        }
    }
}
