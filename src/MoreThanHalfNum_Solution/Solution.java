package MoreThanHalfNum_Solution;

import java.util.HashMap;
import java.util.Map;

public class Solution {

/**
 * @program: offer
 *
 * @description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @author: makaloo
 *
 * @create: 2019-05-16 09:47
 **/
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i]))
                map.put(array[i], map.get(array[i]) + 1);
            else map.put(array[i], 1);
        }
        for (int i = 0; i < map.size(); i++) {
            if (map.get(array[i]) > array.length / 2)
                return array[i];
        }
        return 0;
    }

    // 原理：采用用户“分形叶”思路（注意到目标数 超过数组长度的一半，对数组同时去掉两个不同的数字，到最后剩下的一个数就是该数字。如果剩下多个，那么这多个也是一样的，就是结果）
    public int MoreThanHalfNum_Solution2(int [] array) {
        int length = array.length;
        if (array == null || length == 0){
            return 0;
        }

        int result = array[0];
        int times = 1;
        for (int i = 1; i < length; i++){
            if (times == 0){
                result = array[i];
                times = 1;
            } else {
                if (array[i] == result){
                    times++;
                } else {
                    times--;
                }
            }
        }

        times = 0;
        for (int i = 0; i < length; i++){
            if (result == array[i]){
                times++;
            }
        }

        if (times * 2 < length) {
            result = 0;
        }
        return result;
    }
}
