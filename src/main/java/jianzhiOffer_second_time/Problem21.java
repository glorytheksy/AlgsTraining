package jianzhiOffer_second_time;

import data_structure.StackForInt;

/**
 * @ClassName Problem21
 * @Description 包含min函数的栈
 * @author yxmfi
 * @Date 2018年7月16日 下午7:10:18
 * @version 1.0.0
 */
public class Problem21 {

    private StackForInt s1 = new StackForInt();  
    private StackForInt s2 = new StackForInt();  
    
    public void push(int e) {
        s1.push(e);
        if (!s2.isEmpty()) {
            if (e < s2.peek()) {
                s2.push(e);
            } else {
                s2.push(s2.peek());
            }
        } else {
            s2.push(e);
        }
    }
    
    public int pop() {
        s2.pop();
        return s1.pop();
    }
    
    public int min() {
        return s2.peek();
    }
    
    public static void main(String[] args) {
        Problem21 myStack = new Problem21();
        
        myStack.push(5);
        myStack.push(4);
        myStack.push(3);
        myStack.push(2);
        myStack.push(1);
        
        System.out.println(myStack.min());
        myStack.pop();
        System.out.println(myStack.min());
        myStack.pop();
        System.out.println(myStack.min());
        myStack.pop();
        System.out.println(myStack.min());
        myStack.pop();
    }
    
}
