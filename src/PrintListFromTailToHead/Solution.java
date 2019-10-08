package PrintListFromTailToHead;

import java.util.ArrayList;
import java.util.LinkedList;

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
        p = HEAD;
        HEAD = HEAD.next;
        p.next = null;
        p = null; // help GC
        while (HEAD != null) {
            list.add(HEAD.val);
            HEAD = HEAD.next;
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode == null) return ans;
        ListNode p = listNode;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        while (!stack.isEmpty())
            ans.add(stack.pop().val);
        return ans;
    }

    private ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            ans.add(listNode.val);
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}