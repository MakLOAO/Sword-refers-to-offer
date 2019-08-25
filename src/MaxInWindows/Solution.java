package MaxInWindows;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {

/**
 * @program: offer
 *
 * @description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * @author: makaloo
 *
 * @create: 2019-08-23 17:29
 **/

    /*
    链接：https://www.nowcoder.com/questionTerminal/1624bc35a45c42c0bc17d17fa0cba788
    来源：牛客网

     *     原则：
     *     对新来的元素k，将其与双端队列中的元素相比较
     *     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
     *     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
     *     队列的第一个元素是滑动窗口中的最大值
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++){
            // i指向滑动窗口的尾，q存放的是最大值和潜在最大值的索引，其中队头必为最大值，begin指向头
            begin = i - size + 1; // i与begin之差不超过size，保证队列中队头的最大值是以begin为起始的滑动窗口的最大值
            if (q.isEmpty())
                q.add(i);
            // 当最大值索引小于当前滑动窗口的头索引，意思是当前最大值已经过期
            else if (begin > q.peekFirst())
                q.pollFirst();
            // 当num[i]的值大于前面最大值队列中的值，就将前面最大值队列的值取出
            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if (begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
