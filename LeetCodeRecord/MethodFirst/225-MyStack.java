package MethodFirst;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1 = null;
    Queue<Integer> queue2 = null;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);    
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

class MyStack2 {
    Queue<Integer> queue1 = null;
    Queue<Integer> queue2 = null;
    boolean flag = false; // false 表示 queue1 是目前的取队列

    /** Initialize your data structure here. */
    public MyStack2() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (!flag) {
            queue2.offer(x); 
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            flag = true;   
        } else {
            queue1.offer(x);
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
            flag = false;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!flag) {
            return queue1.poll();
        } else {
            return queue2.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        if (!flag) {
            return queue1.peek();
        } else {
            return queue2.peek();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (!flag) {
            return queue1.isEmpty();
        } else {
            return queue2.isEmpty();
        }
    }
}
