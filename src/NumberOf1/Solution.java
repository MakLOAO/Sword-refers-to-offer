package NumberOf1;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author: makaloo
 *
 * @create: 2019-04-15 10:15
 **/
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if (n / 2 * 2 != n) count++;
            n = n >>> 1;
        }
        return count;
    }

    /*
        public int NumberOf1(int n) {
        int t=0;
            char[]ch=Integer.toBinaryString(n).toCharArray();
            for(int i=0;i<ch.length;i++){
                if(ch[i]=='1'){
                    t++;
                }
            }
            return t;
    }
     */
}