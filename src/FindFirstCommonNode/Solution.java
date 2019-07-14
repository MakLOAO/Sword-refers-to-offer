package FindFirstCommonNode;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入两个链表，找出它们的第一个公共结点。
 *
 * @author: makaloo
 *
 * @create: 2019-07-14 21:49
 **/

//    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        if (pHead1 == null || pHead2 == null) return null;
//        ListNode p1 = pHead1, p2 = pHead2;
//        while (p1.val != p2.val) {
//            p2 = p2.next;
//            if (p2 == null) {
//                p2 = pHead2;
//                p1 = p1.next;
//                if (p1 == null) break;
//            }
//        }
//        if (p1 != null) return p1;
//        else return null;
//    }

    // 公共结点：即该结点的next与val域都是一样的，即该两个链表如果有公共结点，则它们必然最后交汇成一条，第一个公共结点之后的结点都是一样的，必然有公共尾部
    // 算法思路：如果有公共结点，则公共结点之后的结点必然相等，则只需要让更长的链表先走两个链表长度差，然后再逐个比较链表的值是否相等，如果相等则返回该结点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if (pHead1 == null || pHead2 == null) return null;
            int len1 = Length(pHead1), len2 = Length(pHead2), difference;
            ListNode p1 = pHead1, p2 = pHead2;
            if (len1 > len2) {
                difference = len1 - len2;
                while (difference-- != 0)
                    p1 = p1.next;
            } else if (len1 < len2) {
                difference = len2 - len1;
                while (difference-- != 0)
                    p2 = p2.next;
            }
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
    }

    private int Length(ListNode head) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}