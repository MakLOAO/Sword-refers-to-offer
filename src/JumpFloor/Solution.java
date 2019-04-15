package JumpFloor;

public class Solution {

/**
 * @program: offer
 *
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author: makaloo
 *
 * @create: 2019-04-14 20:40
 **/
    /** 
    * @Description: DP问题的变问题，最优子结构：跳上n-1级台阶的时候的跳法+跳上n-2级台阶的的跳法，边界：跳上t级台阶时跳法为t(t<=2)，状态转移方程：f(n)=f(n-1)+f(n-2)
    * @Param: [target]
    * @return: int
    * @Author: makaloo
    * @Date: 2019/4/14
    */ 
    public int JumpFloor(int target) {
        if (target <= 2) return target;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public int JumpFloor1(int target) {
        int jumpSum = 2, temp, jumpSumBefore = 1; // jumpSumBefore和jumpSum为边界
        if (target <= 2) return target;
        while (target---2 > 0) {
            temp = jumpSum;
            jumpSum += jumpSumBefore;
            jumpSumBefore = temp;
        }
        return jumpSum;
    }
}
