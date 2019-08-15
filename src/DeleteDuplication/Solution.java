package DeleteDuplication;

public class Solution {

/**
 * @program: offer
 *
 * @description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author: makaloo
 *
 * @create: 2019-08-15 09:42
 **/
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode head = new ListNode(0), pre, last;
        head.next = pHead;
        pre = head;
        last = pHead;
        while (last != null) {
            if (last.next != null && last.next.val == last.val) {
                while (last.next != null && last.next.val == last.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last.next = null;
                last = pre.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}