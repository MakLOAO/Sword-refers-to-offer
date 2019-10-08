package MinStack;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {

/**
 * @program: offer
 *
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。限制可以使用Stack。
 *
 * @author: makaloo
 *
 * @create: 2019-04-17 21:46
 **/

    // e.g: data: 2 4 1 5 3
    //      minS: 2 2 1 1 1
    // minStack和data等长，minStack保存当前栈内最小值，它与data同步push和同步pop
    LinkedList<Integer> data = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();
    int min = Integer.MAX_VALUE;

    public void push(int node) {
        data.push(node);
        if (!minStack.isEmpty()) min = minStack.peek();
        if (node < min) minStack.push(node);
        else minStack.push(min);
    }

    public void pop() {
        minStack.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
