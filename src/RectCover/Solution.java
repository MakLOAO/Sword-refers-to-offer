package RectCover;

public class Solution {

/**
 * @program: offer
 *
 * @description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author: makaloo
 *
 * @create: 2019-04-15 09:57
 **/
    // 和跳台阶类似，是DP的变形题，最优子结构：2*(n-1)和2*(n-2)矩形的种数之和；边界：2*1时f(1)=1，2*2时f(2)=2；状态转移方程：f(n)=f(n-1)+f(n-2)
    public int RectCover(int target) {
        if (target <= 2) return target;
        int ans = 2, before = 1, temp; // 初始值为边界
        while (target---2 > 0) {
            temp = ans;
            ans += before;
            before = temp;
        }
        return ans;
    }
}
