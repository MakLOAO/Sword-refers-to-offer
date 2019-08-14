package EntryNodeOfLoop;

public class Solution {

/**
 * @program: offer
 *
 * @description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author: makaloo
 *
 * @create: 2019-08-14 20:48
 **/
    // 快慢指针
    // 快指针的速度是慢指针的两倍，当快指针和慢指针相遇，则必定有环
    // 且相遇点到环入口的距离必定等于链表头到环入口的距离（可以证明）
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null) return null;
        ListNode fast, slow;
        fast = slow = pHead;
        // 判断是否有环，并找到相遇点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) return null;
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
