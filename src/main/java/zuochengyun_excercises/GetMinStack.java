package zuochengyun_excercises;

import data_structure_basic.StackForInt;

public class GetMinStack extends StackForInt {
    
    protected StackForInt minStack = new StackForInt();
        
    @Override
    public void push (int element) {
        super.push(element);
        if (minStack.isEmpty()) {            
            minStack.push(element);
        } else {
            minStack.push(element < minStack.peek() ? element : minStack.peek());
        }        
    }
    
    @Override
    public int pop() {
        minStack.pop();        
        return super.pop();
    }
    
    public int getMin() {
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
