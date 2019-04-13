package StackToQueue;

import java.util.Stack;

public class Solution {

/**
 * @program: offer
 *
 * @description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author: makaloo
 *
 * @create: 2019-04-13 09:22
 **/

    /*
    算法思路：每次pop的时候，把s1pop到s2，然后输出s2的栈顶，每次push的时候，把s2pop到s1，然后再push
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) stack2.push(stack1.pop());
        int ans =  stack2.pop();
        while (!stack2.empty()) stack1.push(stack2.pop());
        return ans;
    }
}
