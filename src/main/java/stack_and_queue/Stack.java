package stack_and_queue;

import java.util.LinkedList;

public class Stack {
    
    protected LinkedList<Integer> list = new LinkedList<Integer>();
    
    protected int size;
    
    public void push(Integer element) {        
        list.add(element);
        size++;        
    }
    
    public Integer pop() {
        if (0 == size) {
            throw new RuntimeException();
        }
        size--;
        return list.removeLast();        
    }
    
    public boolean isEmpty() {
        return 0 == size;
    }
    
    public Integer peek() {
        if (0 == size){
            throw new RuntimeException("����Ϊ0");
        }
        return list.get(size - 1);         
    }
    
    public int getSize() {        
        return size;        
    }
}
