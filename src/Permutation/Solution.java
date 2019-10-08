package Permutation;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author: makaloo
 *
 * @create: 2019-05-15 08:34
 **/
    // 算法思想：采用递归，首先依次交换首元素和后面的每一个元素，例如abc得bac，cba，然后固定第一个元素，对后面的元素递归交换，得acb，bca，cab
    // 递归结束条件：i = length - 1（交换到最后一个元素），递归结束后把结果存入list
    // 难点：每次递归结束后都要把数组恢复原来的状态
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) return list;
        Permutation(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    private void Permutation(char[] chars,int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            String result = String.valueOf(chars);
            if (!list.contains(result))
                list.add(result);
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                Permutation(chars, i + 1, list);
                swap(chars, j, i); // 使数组顺序回到递归前的状态，这样不会影响外部的遍历顺序
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
