package FindContinuousSequence;

import java.util.ArrayList;

public class Solution {

/**
 * @program: offer
 *
 * @description: 小明很喜欢数学, 有一天他在做数学作业时, 要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *                  输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * @author: makaloo
 *
 * @create: 2019-07-17 17:02
 **/
    // sliding window
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = 1, right = 2;
        while (left < right) {
            int sumOfSequence = (left + right) * (right - left + 1) / 2;
            if (sumOfSequence == sum) {
                ArrayList<Integer> sequenceList = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    sequenceList.add(i);
                }
                result.add(sequenceList);
                // left++;
            }
            // 这里如果使用的是else if，需要把上面的注释去掉，否则会陷入死循环
            if (sumOfSequence < sum) {
                right++;
            } else {
                left++;
            }
        }
        return result;
    }
}
