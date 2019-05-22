package PrintMinNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @author: makaloo
 *
 * @create: 2019-05-21 08:53
 **/
    /*
     * 排序
     * 若ab > ba 则 a > b，
     * 若ab < ba 则 a < b，
     * 若ab = ba 则 a = b；
     */
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null) return null;
        else if (numbers.length == 0) return "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : numbers) list.add(i);
        list.sort((Integer a, Integer b)-> {
                String s1 = a + "" + b;
                String s2 = b + "" + a;
                return s1.compareTo(s2);
        });
        StringBuilder result = new StringBuilder();
        for (int i : list) result.append(i);
        return result.toString();
    }
}
