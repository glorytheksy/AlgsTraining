package zuochengyun_excercises;

import data_structure.Stack;

public class GetMinStack_v2 {

    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int element) {
        dataStack.push(element);
        if (minStack.isEmpty()) {
            minStack.push(element);
        } else {
            if (element <= (int)(minStack.peek())) {
                minStack.push(element);
            }
        }
    }

    public int pop() {
        if ((int)(dataStack.peek()) <= (int)(minStack.peek())) {
            minStack.pop();
        }
        return (int)(dataStack.pop());
    }

    public Integer peek() {
        return (int)(dataStack.peek());
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

    public int getSize() {
        return dataStack.getSize();
    }

    public Integer getMin() {
        return (int)(minStack.peek());
    }

    public static void main(String[] args) {

    }
}
