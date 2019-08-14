package FirstAppearingOnce;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

/**
 * @program: offer
 *
 * @description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author: makaloo
 *
 * @create: 2019-08-14 16:45
 **/
    private LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        map.put(ch, map.getOrDefault(ch, -1) + 1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) return entry.getKey();
        }
        return '#';
    }
}
