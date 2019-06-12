package FirstNotRepeatingChar;

import java.util.*;

public class Solution {

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
}
