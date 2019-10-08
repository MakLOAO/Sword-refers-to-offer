package MinNumberInRotateArray;

public class Solution {

/**
 * @program: offer
 *
 * @description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author: makaloo
 *
 * @create: 2019-04-13 09:46
 **/
    // 这个解法没有考虑到重复元素，是错误的！！
    // 折半查找的变形，在递增序列中（无重复元素），思路如下：
    // 旋转数组的特征：两个递增序列，后一个递增序列永远小于前一个递增序列，且最小值在后一个递增序列的第一个元素
    // 令left在前面递增序列，right在后面递增序列
    // 判断mid在第一个递增序列(array[mid]>array[left])还是第二个递增序列(array[mid]<array[left])
    // 如果min在第一个递增序列，则left=min，否则right=mid，不断缩小left与right，最后left指向第一个递增序列的最后一个元素，right指向第二个递增序列的第一个元素。
    public int minNumberInRotateArray2(int [] array) {
        int left = 0, right = array.length - 1; // left：旋转数组
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right) / 2;
            min = Math.min(array[mid], min);
            if (array[mid] > array[left]) left = mid; // 此时mid在前面的递增序列中，最小元素在mid后面
            else right = mid; // 此时mid在后面的递增序列
        }
        return min;
    }

    public int minNumberInRotateArray1(int [] array) {
        int i;
        for (i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) break;
        }
        return array[i];
    }

    // 这才是正解
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;
        int left = 0, right = array.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] > array[right]) {
                // 在左半部分，则缩减左半部分
                left = mid + 1;
            } else if (array[mid] == array[right]) {
                // 在右半部分，且mid到right的元素相等
                right--;
            } else {
                // 在右半部分
                right = mid;
            }
        }
        return array[left];
    }
}
