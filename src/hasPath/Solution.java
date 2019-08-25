package hasPath;

public class Solution {

/**
 * @program: offer
 *
 * @description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bccced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * @author: makaloo
 *
 * @create: 2019-08-25 15:24
 **/
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null || rows < 1 || cols < 1 || str == null) return false;
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (hasPath(matrix, i, j, rows, cols, flag, str, 0)) return true;
        return false;
    }

    private boolean hasPath(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        int index = i * cols + j;
        // 过了这关就表示输入符合并且还相等
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[index] || matrix[index] != str[k])
            return false;
        // 过了这关表示还没到尾部，要继续访问该点的上下左右
        if (k == str.length - 1)
            return true;
        flag[index] = true;
        // 过了这关表示该点的上下左右都不符合
        if (hasPath(matrix, i + 1, j, rows, cols, flag, str, k +1 ) ||
                hasPath(matrix, i, j + 1, rows, cols, flag, str, k +1 ) ||
                hasPath(matrix, i - 1, j, rows, cols, flag, str, k +1 ) ||
                hasPath(matrix, i, j - 1, rows, cols, flag, str, k +1 ))
            return true;
        flag[index] = false;
        return false;
    }
}
