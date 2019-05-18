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
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k > input.length || k <= 0) return list;
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < input.length; i++) {
            heap.add(input[i]);
        }
        for (int i = 0; i < k; i++) {
            list.add(heap.poll());
        }
        return list;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
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
