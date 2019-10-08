package FindNumbersWithSum;

import java.util.ArrayList;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author: makaloo
 *
 * @create: 2019-07-17 17:31
 **/
    // 这题同上一题一样也可以用两个指针解决，当两个指针相加的值相同，在最两边的时候乘积一定比在中间的小（如1,2,3,4，1+4=2+3,1*4<2*3）
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int left = 0, right = array.length - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (left < right) {
            int sum1 = array[left] + array[right];
            if (sum1 == sum) {
                ans.add(array[left]);
                ans.add(array[right]);
                return ans;
            } else if (sum1 < sum) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
