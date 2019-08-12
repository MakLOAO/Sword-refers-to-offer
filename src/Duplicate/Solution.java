package Duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {

/**
 * @program: offer
 *
 * @description: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * @author: makaloo
 *
 * @create: 2019-08-12 09:03
 **/

//    public boolean duplicate(int numbers[],int length,int [] duplication) {
//        if (numbers == null || numbers.length == 0) return false;
//        boolean sign = false;
//        Set<Integer> set = new HashSet<>();
//        for (int i = length - 1; i >= 0; i--) {
//            if (set.contains(numbers[i])) {
//                duplication[0] = numbers[i];
//                sign = true;
//            } else set.add(numbers[i]);
//        }
//        return sign;
//    }

    // 不使用额外辅助空间，可以排序，这样的时间复杂度为时间复杂度为O(nlog2n)
    // 设置辅助数组，以空间换时间的解法，时间复杂度为O(N) 空间复杂度为O(N)（设计一个计数数组，下标为对应元素，值为出现次数）
    // 最优解法：
    /*
    把当前序列当成是一个下标和下标对应值是相同的数组；
    遍历数组，判断当前位的值和下标是否相等：
    2.1. 若相等，则遍历下一位；
    2.2. 若不等，则将当前位置i上的元素和a[i]位置上的元素比较：
    若它们相等，则成功！若不等，则将它们两交换。
    换完之后a[i]位置上的值和它的下标是对应的，但i位置上的元素和下标并不一定对应；
    重复2.2的操作，直到当前位置i的值也为i，将i向后移一位，再重复2.
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0) return false;
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] >= length) return false;
            if (numbers[i] != i) {
                int temp = numbers[i];
                if (temp == numbers[temp]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }
        return false;
    }
}
