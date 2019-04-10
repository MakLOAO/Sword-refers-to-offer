package Find;

public class Solution {

/**
 * @program: offer
 *
 * @description: 二维数组的查找，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 *
 *              e.g.
 *                      1 2 8 9
 *                      2 4 9 12
 *                      4 7 10 13
 *                      6 8 11 15
 *
 * @author: makaloo
 *
 * @create: 2019-04-10 20:19
 **/

    // 算法思想：对每一行数组折半查找，时间复杂度O(nlogn)
    public boolean Find(int target, int [][] array) {
        int low, high, mid;
        int len = array[0].length;
        for (int i = 0; i < array.length; i++) {
            low = 0; high = len - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (array[i][mid] == target) return true;
                else if (array[i][mid] < target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }

    // 矩阵的特点是每个点的上面元素都比它小，左边元素都比它大
    public boolean Find1(int target, int [][] array) {
        int rowLen = array.length;
        int colLen = array[0].length;
        int row = rowLen - 1, col = 0;
        while (row < rowLen && col < colLen && row >= 0 && col >= 0) {
            if (target == array[row][col]) return true;
            else if (target > array[row][col]) col++;
            else row--;
        }
        return false;
    }
}
