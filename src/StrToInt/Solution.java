package StrToInt;

public class Solution {

    /**
     * @program: offer
     *
     * @description: 将一个字符串转换成一个整数(实现Integer.valueOf ( string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
     *
     * @author: makaloo
     *
     * @create: 2019-08-01 18:01
     **/
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        char c;
        int sign = 1;
        int result = 0;
        // 处理第一个字符，可能是数字，+，-号
        c = str.charAt(0);
        if (str.length() != 1) {
            if (c == '+') sign = 1;
            else if (c == '-') sign = -1;
            else if (c <= '9' && c >= '0') {
                result = c & 0xf; // c - '0'
                sign = 1;
            }
        } else {
            if (c <= '9' && c >= '0')
                return c & 0xf; // c - '0'
             else return 0;
        }
        // 处理剩下的字符
        for (int i = 1; i < str.length(); i++) {
            c = str.charAt(i);
            if (c <= '9' && c >= '0')
                result = (result << 1) + (result << 3) + (c & 0xf); // 等价于result = result * 10 + (c - '0')，字符'0'到'9'的ascii值的低4个二进制位刚好就是0到9
            else return 0;
        }
        return result * sign;
    }
}
