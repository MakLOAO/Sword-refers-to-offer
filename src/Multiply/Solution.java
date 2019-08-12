package Multiply;

public class Solution {

/**
 * @program: offer
 *
 * @description: 给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * @author: makaloo
 *
 * @create: 2019-08-12 16:14
 **/

    /*
    算法思路：把B[i]的值看作是下面矩阵每行的乘积
    B[0]   |   1     A[1]    A[2]    A[3]    ...    A[n-3]    A[n-2]    A[n-1]
    B[1]   |  A[0]     1     A[2]    A[3]    ...    A[n-3]    A[n-2]    A[n-1]
    B[2]   |  A[0]   A[1]     1      A[3]    ...    A[n-3]    A[n-2]    A[n-1]
    ...
    B[n-3] |  A[0]   A[1]    A[2]    A[3]    ...       1      A[n-2]    A[n-1]
    B[n-2] |  A[0]   A[1]    A[2]    A[3]    ...    A[n-3]       1      A[n-1]
    B[n-1] |  A[0]   A[1]    A[2]    A[3]    ...    A[n-3]    A[n-2]       1
     这样，先计算下三角的值（B[i]的一部分），再计算上三角的值即可得出结果
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return new int[0];
        int length = A.length;
        int[] B = new int[length];
        // 计算下三角，包括对角
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        // 计算上三角
        int temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] = B[i] * temp;
        }
        return B;
    }
}
