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
        int rowTop = 0, rowBottom = matrix.length - 1;
        int colLeft = 0, colRight = matrix[0].length - 1;
        int row = rowTop, col = colLeft;
        while (rowTop <= rowBottom && colLeft <= colRight) {
            if (rowTop <= rowBottom && colLeft <= colRight) {
                for (col = colLeft; col <= colRight; col++) {
                    list.add(matrix[row][col]);
                }
                rowTop++;
                col--;
                for (row = rowTop; row <= rowBottom; row++) {
                    list.add(matrix[row][col]);
                }
                colRight--;
                row--;
            }
            if (rowTop <= rowBottom && colLeft <= colRight) {
                for (col = colRight; col >= colLeft; col--) {
                    list.add(matrix[row][col]);
                }
                rowBottom--;
                col++;
                for (row = rowBottom; row >= rowTop; row--) {
                    list.add(matrix[row][col]);
                }
                colLeft++;
                row++;
            }
        }
        return list;
    }
}
