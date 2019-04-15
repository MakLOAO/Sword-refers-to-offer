package JumpFloorII;

public class Solution {

/**
 * @program: offer
 *
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author: makaloo
 *
 * @create: 2019-04-15 09:40
 **/

    // 思路见JumpFloor，通过找规律直接得结果
    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    // 讨论中别人得做法
    public int JumpFloorII1(int target) {
        int a = 1;
        return a << (target - 1);
    }
}
