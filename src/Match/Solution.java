package Match;

public class Solution {

/**
 * @program: offer
 *
 * @description: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * @author: makaloo
 *
 * @create: 2019-08-12 21:00
 **/
/*
链接：https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
来源：牛客网

当模式中的第二个字符不是“*”时：
1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

而当模式中的第二个字符是“*”时：
如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有2种匹配方式：
1、模式后移2字符，相当于x*被忽略，匹配0个；
2、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位，匹配多个（继续匹配下一个）；
 */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        int strIndex = 0, patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length)
            return true;
        // 如果串到达终点而模式还没到终点，则表示匹配失败
        // 而如果串到终点，模式还没到终点，则不一定，因为可能有 "" 和 "x*"的情况
        if (strIndex != str.length && patternIndex == pattern.length)
            return false;
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (strIndex < str.length
                    && patternIndex < pattern.length
                    && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                // 返回只匹配0个或匹配1个的情况（递归的情况下，总会有结束的时候，这个结束的时候就是匹配0个时候）
                // 模式串匹配0个的情况，比如a和a*a，则a*匹配0个，a和后面的a匹配
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                // 当*之前的不相等且不为 . ，则直接让模式往后走2步，跳过*
                return matchCore(str, strIndex, pattern, patternIndex + 2); // aa与b*ac*a的情况
            }
        }
        // 如果没有*，则相等或为 . 的时候，就让模式和串往后走一步
        if (strIndex < str.length
                && patternIndex < pattern.length
                && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
