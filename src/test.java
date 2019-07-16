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
        String[] ss = {"a", "b", "c"};
        List<String> strings = Arrays.asList(ss);
//        integerList.add("d");
        strings.set(1, "f");
        System.out.println(strings.get(1));
    }
}
