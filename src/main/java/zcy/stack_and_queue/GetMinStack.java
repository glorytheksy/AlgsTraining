package zcy.stack_and_queue;

import utils.Stack;

public class GetMinStack extends Stack{
    
    protected Stack minStack = new Stack();
        
    @Override
    public void push (Integer element) {
        if (null == element) {
            throw new RuntimeException("����������Ԫ��");            
        }        
        
        super.push(element);
        if (minStack.isEmpty()) {            
            minStack.push(element);
        } else {
            minStack.push(element < minStack.peek() ? element : minStack.peek());
        }        
    }
    
    @Override
    public Integer pop() {
        minStack.pop();        
        return super.pop();
    }
    
    public Integer getMin() {
        return minStack.peek();
    }
    
    public static void main(String[] args) {
        GetMinStack s = new GetMinStack();
        s.push(6);
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();


        
    }

}
