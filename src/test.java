import GetNumberOfK.Solution;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

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
    {
        S += 3;
    }
    static int M = 1;
    static int S = M + 1;
    public test(int var) {
        System.out.println(M);
        System.out.println(S);
        M = var;
        System.out.println(M++);
        System.out.println(S);
    }
    public long getResult(long n) {
        if (n < 0) return -1;
        return getResultCore(n, 5);
    }

    public long getResultCore(long n, long limit) {
        return n <= limit ? n : getResultCore(n - limit, limit * 2);
    }


    public static void main(String[] args) throws InterruptedException {
        String a = "abcaa";
        String b = a.replace("a", "A");
        System.out.println(b);
    }
}


