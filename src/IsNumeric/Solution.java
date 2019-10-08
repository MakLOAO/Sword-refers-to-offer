package IsNumeric;

public class Solution {

/**
 * @program: offer
 *
 * @description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author: makaloo
 *
 * @create: 2019-08-13 09:17
 **/
    /*
    分为两部分，e前面的和e后面的
    e前面第一位可以带±，然后只能带一个点
    e后面第一位可以带±，不能带任何点
    ±后可以直接带点，点前可以没有任何数字，但是点后必须要有数字
     */
    private int index;
    public boolean isNumeric(char[] str) {
        if (str.length == 0 || str == null) return false;
        boolean flag = isNumber(str);
        // 如果遇到小数点，则判断小数点后面是否是纯数字
        if (index < str.length && str[index] == '.') {
            index++;
            // 小数点之前可以无数字，因此这里使用 ||
            flag = isUnsignedNumber(str) || flag;
        }
        // 如果有E，判断E之后的是否为数字
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            // E之前必须有数字，因此这里使用 &&
            flag = isNumber(str) && flag;
        }
        // e之后有数字，且只有数字
        return flag && index == str.length;
    }

    private boolean isNumber(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return isUnsignedNumber(str);
    }

    private boolean isUnsignedNumber(char[] str) {
        int start = index;
        while (index < str.length && str[index] <= '9' && str[index] >= '0')
            index++;
        return start < index;
    }
}