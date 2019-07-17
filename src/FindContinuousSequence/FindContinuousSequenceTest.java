package FindContinuousSequence;

import java.util.ArrayList;

public class FindContinuousSequenceTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-07-17 17:23
 **/

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> list = s.FindContinuousSequence(10);
        for (ArrayList<Integer> sequence : list) {
            sequence.forEach(i -> System.out.println(i));
        }
    }
}
