package ReplaceSpace;

public class Solution {

/**
 * @program: offer
 *
 * @description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author: makaloo
 *
 * @create: 2019-04-12 07:18
 **/
    public String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                str.replace(i, i + 1, "%20");
        }
        return str.toString();
    }

    public String replaceSpace2(StringBuffer str) {
        if (str == null) return null;
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                ans.append("%");
                ans.append("2");
                ans.append("0");
            } else
                ans.append(str.charAt(i));
        }
        return ans.toString();
    }
}
