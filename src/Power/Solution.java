package Power;

public class Solution {

/**
 * @program: offer
 *
 * @description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @author: makaloo
 *
 * @create: 2019-04-15 10:54
 **/
    // 使用位运算的方法
    public double Power(double base, int exponent) {
        // return Math.pow(base, exponent); 开玩笑的233
        double res = 1,curr = base;
        boolean positive;
        if (exponent > 0) {
            positive = true;
        } else if (exponent < 0) {
            if (base == 0)
                throw new RuntimeException("分母不能为0");
            exponent = -exponent;
            positive = false;
        } else {
            return 1;
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1)
                res *= curr;
            curr *= curr; // 翻倍
            exponent >>= 1; // 右移一位
        }
        return positive ? res : (1 / res);
    }
}
