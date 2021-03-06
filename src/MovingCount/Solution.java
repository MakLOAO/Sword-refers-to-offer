package MovingCount;

public class Solution {

    /**
     * @program: offer
     *
     * @description: 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     *
     * @author: makaloo
     *
     * @create: 2019-08-25 15:39
     **/

    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows < 1 || cols < 1) return 0;
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0 ; i < visited.length; i++)
            visited[i] = false;
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int i, int j, boolean[] visited) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[index] || numCount(i) + numCount(j) > threshold) return 0;
        visited[index] = true;
        return movingCountCore(threshold, rows, cols, i - 1, j, visited) +
                movingCountCore(threshold, rows, cols, i + 1, j, visited) +
                movingCountCore(threshold, rows, cols, i, j - 1, visited) +
                movingCountCore(threshold, rows, cols, i, j + 1, visited) +
                1;
    }

    private int numCount(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}
