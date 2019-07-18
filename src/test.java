import GetNumberOfK.Solution;

import java.util.*;

public class test {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-04-14 21:10
 **/
    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "a");
//        map.put(2, "b");
//        map.put(3, "c");
//        map.forEach((k, v) -> {
//            // do something with k, v
//        });
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            // do something with entry.getKey() + entry.getValue();
//        }
        String s = "hello aha";
        char[] c = s.toCharArray();
        reverseStr(c, 0, s.length());
        System.out.println(String.valueOf(c));
    }

    private static void reverseStr(char[] chars, int begin, int end) {
        for (int i = begin; i < end / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[end - i - 1];
            chars[end - i - 1] = temp;
        }
    }
}
