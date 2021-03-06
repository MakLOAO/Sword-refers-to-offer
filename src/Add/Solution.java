package Add;

public class Solution {

/**
 * @program: offer
 *
 * @description: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 *
 * @author: makaloo
 *
 * @create: 2019-08-01 12:11
 **/
    // 加法三步走，以7+5为例：1.相加各位的值，不算进位，得2   2.计算进位，7+5的进位为10  3.重复上述步骤，只是相加的值变成上述两个步骤的结果2和10，得到12
    // 2进制也是同理，5-101,7-111，第一步，相加各位的值，不算进位得010，第二步，计算进位得1010，第三步，重复1和2，只是把相加的值变成上面两步的010和1010
    // 不算进位得相加操作实际是异或，计算进位实际是与操作再左移1
    public int Add(int num1,int num2) {
        while (num2 != 0) {            // 当进位结果为0的时候，不算进位得相加结果num1就是最终结果
            int temp = num1 ^ num2;    // 不算进位的相加结果
            num2 = (num1 & num2) << 1; // num2是每次num1+num2时的进位结果
            num1 = temp;               // num1是每次num1+num2不算进位的相加结果
        }
        return num1;
    }
    // 每次相加时，num2是作为进位，num1作为结果，当进位=0的时候，就意味着不需要再和进位相加了，num1就是最终结果了
    /*
    链接：https://www.nowcoder.com/questionTerminal/59ac416b4b944300b617d4f7f111b215
    来源：牛客网

    13+11 = ？;
    13 的二进制      1 1 0 1                     ------a       13
    11 的二进制      1 0 1 1                     ------b       11

     (a&b) <<1  ->   1 0 0 1 0                   ------d       18
           a^b  ->     0 1 1 0                   ------e        6

     (d&e) <<1  ->   0 0 1 0 0                   ------f        4
           d^e  ->   1 0 1 0 0                   ------g       20

     (f&g) <<1  ->   0 1 0 0 0                   ----- h        8
           f^g  ->   1 0 0 0 0                   ------i       16

     (h&i) <<1  ->   0 0 0 0 0                   ------h        0       ------------退出循环
           h^i  ->   1 1 0 0 0                   ------i       24
     */
}
