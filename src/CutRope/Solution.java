package CutRope;

public class Solution {

    /**
     * @program: offer
     *
     * @description: 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * @author: makaloo
     *
     * @create: 2019-10-05 10:48
     **/

    // 贪婪算法，证明略，需要尽可能多的长度为3的绳子，但如果剩下的绳子长度为4，则不要分为1,3，而是分为2,2，因为2*2>1*3，剩下的绳子剪成长度为2的绳
    public int cutRope(int target) {
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;
        int timesOf3 = target / 3;
        // 长度为4的话，就分为2,2
        if (target - 3 * timesOf3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (target - timesOf3 * 3) / 2;
        return (int)(Math.pow(2, timesOf2) * Math.pow(3, timesOf3));
    }
}
