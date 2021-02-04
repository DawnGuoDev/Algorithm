package MethodFirst;

import java.util.Stack;

class Minstack {
    Stack<Integer> normalStack = null;
    Stack<Integer> minStack = null;

    /** initialize your data structure here. */
    public MinStack() {
        normalStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
        normalStack.push(x);
    }
    
    public void pop() {
        // 这里需要显式的转换成 int，否则比较的是 Integer
        if ((int)minStack.peek() == (int)normalStack.peek()) {
            minStack.pop();
        }
        normalStack.pop();
    }
    
    public int top() {
        return normalStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
