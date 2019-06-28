package InversePairs;

import java.util.Arrays;

public class Solution {

/**
 * @program: offer
 *
 * @description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * @author: makaloo
 *
 * @create: 2019-06-12 08:44
 **/

    /*
    算法思路：归并排序
    1,2,3,4,5,6,7,0
    12,34,56,70先比较找出逆序，然后调换顺序
    1234,5607再找逆序对，最后12340567再找逆序对，这样可以确保所有的逆序对都会被找到且不会重复
    找逆序对并排序的算法：对两个数组都用一个指针指向末尾，比较两个值的大小
    如果第一个子数组中的数字大于第二个数组中的数字，则构成逆序对，并且逆序对的数目等于第二个子数组中剩余数字的个数
    每一次比较的时候，我们都把较大的数字从后面往前复制到一个辅助数组中，确保 辅助数组（记为copy） 中的数字是递增排序的
    在把较大的数字复制到辅助数组之后，把对应的指针向前移动一位，接下来进行下一轮比较
     */
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) return 0;
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return InversePairs(array, copy, 0, array.length - 1);
    }

    private int InversePairs(int[] array, int[] copy, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            int left = InversePairs(array, copy, low, mid) % 1000000007;
            int right = InversePairs(array, copy, mid + 1, high) % 1000000007;
            return (left + right + Merge(array, copy, low, mid, high)) % 1000000007;
        }
        return 0;
    }

    private int Merge(int[] array, int[] copy, int low, int mid, int high) {
        int ans = 0;
        int i, j, k;
        System.arraycopy(array, low, copy, low, high - low + 1);
        for (i = mid, j = high, k = j; i >= low && j >= mid + 1; k--) {
            if (copy[i] <= copy[j]) {
                array[k] = copy[j--];
            } else {
                array[k] = copy[i--];
                ans += j - mid;
                if (ans >= 1000000007)
                    ans = ans % 1000000007;
            }
        }
        while (i >= low) array[k--] = copy[i--];
        while (j >= mid + 1) array[k--] = copy[j--];
        return ans;
    }
}
