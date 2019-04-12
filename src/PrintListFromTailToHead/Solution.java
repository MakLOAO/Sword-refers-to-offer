package PrintListFromTailToHead;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-04-12 07:36
 **/
    // if we can change the linked list
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode HEAD = new ListNode(0);
        ListNode p = listNode;
        ListNode q;
        ArrayList<Integer> list = new ArrayList<>();
        while (p != null) {
            q = p.next;
            p.next = HEAD.next;
            HEAD.next = p;
            p = q;
        }
        HEAD = HEAD.next;
        while (HEAD != null) {
            list.add(HEAD.val);
            HEAD = HEAD.next;
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = listNode;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty())
            list.add(stack.pop());
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}