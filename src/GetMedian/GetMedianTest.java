package GetMedian;

import java.util.Scanner;

public class GetMedianTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-08-21 09:56
 **/
    private static Solution s = new Solution();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            s.Insert(scanner.nextInt());
            System.out.println(s.GetMedian());
        }
    }
}
