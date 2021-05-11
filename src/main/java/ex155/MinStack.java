package ex155;

import java.util.LinkedList;

/**
 * @author SongOf
 * @ClassName MinStack
 * @Description
 * @Date 2021/3/13 10:46
 * @Version 1.0
 */
public class MinStack {
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
