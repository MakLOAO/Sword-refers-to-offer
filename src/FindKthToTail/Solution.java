package FindKthToTail;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author: makaloo
 *
 * @create: 2019-04-15 22:13
 **/

    // 最简单的方法：遍历计算链表长度，然后输出第n-k个结点
    public ListNode FindKthToTail(ListNode head, int k) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        p = head;
        if (k > length) return null;
        // 走length-k步到倒数第k个结点
        for (int i = 1; i < length - k + 1; i++) {
            p = p.next;
        }
        return p;
    }

    // 看到别人更好的代码，思路是先让pre走k-1步到第k个结点，然后pre和last往后走，直到pre走到了最后(pre走了length-k步)，last就走了length-k步，即last为倒数第k个结点
    public ListNode FindKthToTail1(ListNode head, int k) {
        if (k <= 0 || head == null) return null;
        ListNode pre = head, last = head;
        for (int i = 1; i <= k - 1; i++) {
            if (pre.next != null)
                pre = pre.next;
            else return null;
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
