package GetLeastNumbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @author: makaloo
 *
 * @create: 2019-05-17 10:09
 **/

    // 用二叉堆实现，构造函数为PriorityQueue(int initialCapacity, Comparator<? super E> comparator) ，自己实现comparator
    /*
    一个控制空间复杂度在O(k)（k是最小的k个元素）的方法是：
    创建只有k个元素的**大顶堆**，遍历input数组，如果堆的容量不等于k，就直接offer进去，
    如果等于k，判断堆顶元素是否比待插入元素大，如果是则出堆，让待插入元素进堆，
    这样遍历结束后，堆就是只有最小的4个元素的堆
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k > input.length || k <= 0) return list;
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (heap.size() != k)
                heap.add(input[i]);
            else if (heap.peek() > input[i]) {
                heap.poll();
                heap.add(input[i]);
            }
        }
        for (int i = 0; i < k; i++)
            list.add(heap.poll());
        return list;
    }
}
