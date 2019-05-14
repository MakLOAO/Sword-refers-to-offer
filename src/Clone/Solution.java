package Clone;

import java.util.HashMap;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author: makaloo
 *
 * @create: 2019-05-14 08:00
 **/

    // 三步法：旧链表创建新链表，根据旧链表兄弟结点初始化新链表兄弟结点，从旧链表拆分
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode p1 = pHead, p2;
        while (p1 != null) {
            p2 = p1.next;
            p1.next = new RandomListNode(p1.label);
            p1.next.next = p2;
            p1 = p2;
        }
        p1 = pHead;
        while (p1 != null) {
            if (p1.random != null)
                p1.next.random = p1.random.next;
            p1 = p1.next.next;
        }
        p1 = pHead;
        p2 = p1.next;
        RandomListNode head = p2;
        while (p1 != null) {
            p1.next = p1.next.next;
            if (p2.next != null)
                p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        return head;
    }

    // map法，map键为旧链表结点，值为新链表结点
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode head = new RandomListNode(pHead.label);
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(pHead, head);
        RandomListNode p1 = pHead, p2 = head;
        while (p1.next != null) {
            p2.next = new RandomListNode(p1.next.label);
            map.put(p1.next, p2.next);
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = null;
        p1 = pHead;
        p2 = head;
        while (p1 != null) {
            p2.random = map.get(p1.random);
            p1 = p1.next;
            p2 = p2.next;
        }
        return head;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}