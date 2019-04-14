package Fibonacci;

public class Solution {

/**
 * @program: offer
 *
 * @description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 *
 * @author: makaloo
 *
 * @create: 2019-04-14 20:08
 **/

    /**
    * @Description: 算法思想：使用DP的思想，最优子结构；边界：n=1，f(1)=1，n=2，f(2)=1；状态转移方程：f(n)=f(n-1)+f(n-2)
    * @Param: [n]
    * @return: int
    * @Author: makaloo
    * @Date: 2019/4/14
    */
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        int pre = 0, now = 1, temp;
        while (--n > 0) {
            temp = now;
            now = now + pre;
            pre = temp;
        }
        return now;
    }

    // 递归方法，浪费空间和时间
    public int Fibonacci1(int n) {
        if (n <= 1) return n;
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }
}
