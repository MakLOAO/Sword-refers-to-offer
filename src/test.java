import GetNumberOfK.Solution;

import java.io.IOException;
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

    static {
        i = 0; // 正常编译通过
        //System.out.println(i); // 提示非法向前引用
    }
    static int i = 1;
    public static void main(String[] args) throws InterruptedException {
        TreeMap<String, String> hashMap = new TreeMap<>();
        hashMap.put("?", null);
        System.out.println(hashMap.get(null));
    }


}
