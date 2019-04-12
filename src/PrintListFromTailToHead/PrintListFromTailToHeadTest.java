package PrintListFromTailToHead;

import java.util.ArrayList;

public class PrintListFromTailToHeadTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-04-12 09:32
 **/
    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        ListNode q = new ListNode(2);
        ListNode r = new ListNode(3);
        p.next = q; q.next = r;
        Solution s = new Solution();
        ArrayList list = s.printListFromTailToHead(p);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
