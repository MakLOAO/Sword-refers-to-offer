package ReOrderArray;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author: makaloo
 *
 * @create: 2019-04-15 12:12
 **/
    // 算法思想：插入排序的变形，当找到奇数时，记录后移操作
    public void reOrderArray(int [] array) {
        int i, j;
        for (i = 1; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int temp = array[i];
                for (j = i - 1; j >= 0 && array[j] % 2 == 0; j--)
                    array[j + 1] = array[j];
                array[j + 1] = temp;
            }
        }
    }
}
