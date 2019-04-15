package ReOrderArray;

public class ReOrderArrayTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-04-15 21:55
 **/
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 1, 3, 5, 7, 9};
        System.out.println("Expected:");
        System.out.println("1, 3, 5, 7, 9, 2, 4, 6");
        Solution solution = new Solution();
        solution.reOrderArray(array);
        System.out.println("Answer:");
        for (int i : array)
            System.out.print(i + ", ");
    }
}
