package NumberOf1Between1AndN_Solution;

public class Solution {

/**
 * @program: offer
 *
 * @description: 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * @author: makaloo
 *
 * @create: 2019-05-20 08:53
 **/
    // 从每一位出现1的次数去考虑，个位出现1次数受高位影响，十位出现1次数可能受个位和自己本身和高位的影响，百位出现1次数可能受地位，自身，高位影响，找出规律
    /*
    百位出现1的次数受高位和低位和自身的影响
    如果百位为0，受高位影响，如12013，共有100-199，1100-1199，2100-2199，3100-3199，。。。，10100-10199，11100-11199，12*100，即高位数字*当前位数
    如果百位为1，受低位和高位影响，如12113，共有上面所说的1200个再加上12100-12113，即共有高位*位数+低位+1个
    如果百位大于1，受高位，如12313，共有100-199，。。。，11100-11199，12100-12199，共有(高位+1)*位数
    */
    public int NumberOf1Between1AndN_Solution(int n) {
        int v = 1, count = 0;
        while (v <= n) {
            int high = n / (v * 10);
            int now = n / v % 10;
            int low = n - n / v * v;
            if (now == 0) count = count + high * v;
            else if (now == 1) count = count + high * v + low + 1;
            else count = count + (high + 1) * v;
            v *= 10;
        }
        return count;
    }
}
