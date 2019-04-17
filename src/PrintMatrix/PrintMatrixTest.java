package PrintMatrix;

import java.util.ArrayList;

public class PrintMatrixTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-04-17 16:18
 **/
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        Solution s = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        list = s.printMatrix(matrix);
        for (int i : list)
            System.out.println(i);
    }
}
