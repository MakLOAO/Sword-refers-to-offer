package FirstNotRepeatingChar;

import java.util.*;

public class Solution {
    /**
     * @program: offer
     *
     * @description: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
     *
     * @author: makaloo
     *
     * @create: 2019-06-11 08:44
     **/

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (!map.containsKey(temp))
                map.put(temp, 1);
            else map.put(temp, map.get(temp) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (map.get(temp) == 1) return i;
        }
        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length() == 0) return -1;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (!map.containsKey(temp))
                map.put(temp, 1);
            else map.put(temp, map.get(temp) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return str.indexOf(entry.getKey());
        }
        return -1;
    }
}
