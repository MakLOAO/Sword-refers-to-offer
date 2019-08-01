package Sum_Solution;

public class Solution {

/**
 * @program: offer
 *
 * @description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * @author: makaloo
 *
 * @create: 2019-08-01 11:12
 **/
    // 利用逻辑与的短路特性实现递归的终止
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
