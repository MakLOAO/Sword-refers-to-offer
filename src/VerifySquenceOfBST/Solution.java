package VerifySquenceOfBST;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author: makaloo
 *
 * @create: 2019-04-24 21:08
 **/

    // 算法思想：判断数组前面的值是否小于最后一个值，后面的值是否大于最后一个值，如果是，则递归判断前部分和后部分
    // 没做出来的一个点是没想到哪里判断为true，以及要注意每次都要舍弃数组最后一个值（即根）
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBST(int [] sequence, int start, int end) {
        if (start >= end) return true;
        int root = sequence[end];
        int index = start;
        // 刚好last可以作为哨兵
        while (sequence[index] < root) {
            index++;
        }
        int mid = index;
        while (index < end - 1) {
            if (sequence[index] < root)
                return false;
            else index++;
        }
        return VerifySquenceOfBST(sequence, start, mid - 1) && VerifySquenceOfBST(sequence, mid, end - 1);
    }
}
