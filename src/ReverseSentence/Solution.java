package ReverseSentence;

public class Solution {

/**
 * @program: offer
 *
 * @description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * @author: makaloo
 *
 * @create: 2019-07-18 16:58
 **/
    // 要求空间复杂度为O(1)
    // 剑指offer中的正解思想是先翻转整个字符串，再逐个单词翻转，这样可以使得空间复杂度是O(1)
    // 但在Java中，字符串对象并不是字符数组，所以需要转换为字符数组，即O(n)的空间复杂度
    // 但在实现上，仍然使用翻转两次的实现
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return str;
        str = " " + str; // 翻转后在结尾添加空格，这样最后一个单词也会翻转
        char[] chars = str.toCharArray();
        int border = 0;
        reverseStr(chars, 0, str.length()); // 第一次翻转
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseStr(chars, border, i); // 第二次翻转
                border = i + 1; // 每两个单词之间只有一个空格
            }
        }
        return String.valueOf(chars).substring(0, chars.length - 1);
    }

    private void reverseStr(char[] chars, int begin, int end) {
        for (int i = begin; i < begin + (end - begin) / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[end - i - 1 + begin];
            chars[end - i - 1 + begin] = temp;
        }
    }
}
