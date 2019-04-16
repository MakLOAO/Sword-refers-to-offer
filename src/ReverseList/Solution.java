package ReverseList;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author: makaloo
 *
 * @create: 2019-04-16 21:21
 **/
    public ListNode ReverseList(ListNode head) {
        ListNode HEAD = new ListNode(0);
        ListNode next, p = head;
        while (p != null) {
            next = p.next;
            p.next = HEAD.next;
            HEAD.next = p;
            p = next;
        }
        return HEAD.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}