package zcy.stack_and_queue;

import utils.Stack;

public class GetMinStack_v2 {
    
    Stack dataStack = new Stack();
    Stack minStack = new Stack();
    
    public void push(Integer element) {
        dataStack.push(element);
        if (minStack.isEmpty()){
            minStack.push(element);
        } else {
            if  (element <= minStack.peek()) {
                minStack.push(element);
            }
        }        
    }

    public Integer pop() {
        if (dataStack.peek() <= minStack.peek()) {
            minStack.pop();
        } 
        return dataStack.pop();
    }
    
    public Integer peek() {
        return dataStack.peek();
    }
    
    public boolean isEmpty(){
        return dataStack.isEmpty();
    }
    
    public int getSize(){
        return dataStack.getSize();
    }
    
    public Integer getMin() {
        return minStack.peek();
    }
    
    public static void main(String[] args) {
        
    }
}
