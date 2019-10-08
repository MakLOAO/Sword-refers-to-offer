package PrintMatrix;

import java.util.ArrayList;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 *               1 2 3 4
 *               5 6 7 8
 *               9 10 11 12
 *               13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @author: makaloo
 *
 * @create: 2019-04-17 12:18
 **/

    // 算法思想：每次走半圈就if内判断，防止奇数行时走到中间行从左往右走然后又原路返回的情况（或奇数列），然后while外判断是走一圈后判断是否走完
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            if (++up > down)
                break;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if (--right < left)
                break;
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            if (--down < up)
                break;
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right)
                break;
        }
        return list;
    }
}
