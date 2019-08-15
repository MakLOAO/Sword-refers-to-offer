package DeleteDuplication;

import java.util.Scanner;

public class DeleteDuplicationTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-08-15 10:28
 **/
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode p = new ListNode(1), head = p;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        s.deleteDuplication(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
