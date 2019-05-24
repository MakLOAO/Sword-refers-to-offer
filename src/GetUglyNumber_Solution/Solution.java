package GetUglyNumber_Solution;

import java.util.ArrayList;

public class Solution {

/**
 * @program: offer
 *
 * @description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @author: makaloo
 *
 * @create: 2019-05-22 09:07
 **/
    /*
    思路，
    如果p是丑数，那么p=2^x * 3^y * 5^z
    对于任何丑数p：
    （一）那么2*p,3*p,5*p都是丑数，即一个丑数由另一个丑数*2或*3或*5而得，并且2*p<3*p<5*p
    （二）如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q
    一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，那么我们从1开始乘以2,3,5，就得到2,3,5三个丑数，
    在从这三个丑数出发乘以2,3,5就得到4，6,10,6，9,15,10,15,25九个丑数，
    我们发现这种方法会得到重复的丑数，而且我们题目要求第N个丑数，这样的方法得到的丑数也是无序的。那么我们可以维护三个队列：
    1.丑数数组： 1      2.丑数数组： 1,2        3.丑数数组：1,2,3           4.丑数数组：1,2,3,4
    乘以2的队列：2*1    乘以2的队列：②，  2*2  乘以2的队列：②， 2*2, 2*3   乘以2的队列：②，④,  2*3
    乘以3的队列：3*1    乘以3的队列：3*1， 3*2  乘以3的队列：③， 3*2, 3*3   乘以3的队列：③，3*2, 3*3
    乘以5的队列：5*1    乘以5的队列：5*1， 5*2  乘以5的队列：5,   5*2, 5*3   乘以5的队列：5,  5*2, 5*3
    算法思想：维护队列开销很大，而且不是必要的
    观察上面，可以发现只要3个指针就可以实现这三个数组，这3个指针指向丑数数组，分别代表丑数数组中该指针对应值乘以2，3，5后的最小值
    比较这三个最小值更小的输出，相应指针加一即可
    */
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        int p2 = 0, p3 = 0, p5 = 0;
        int num2, num3, num5;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < index - 1; i++) {
            num2 = list.get(p2) * 2;
            num3 = list.get(p3) * 3;
            num5 = list.get(p5) * 5;
            int min = Math.min(num2, Math.min(num3, num5));
            // 不能用else if，要考虑到有重复的值，比如2*3和3*2都是6，这时p2和p3都要往前走
            if (min == num2) p2++;
            if (min == num3) p3++;
            if (min == num5) p5++;
            list.add(min);
        }
        return list.get(index - 1);
    }
}
