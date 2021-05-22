package data_structure_basic;

import java.util.LinkedList;

public class StackForInt {

    protected String name;
    protected int size;

    protected LinkedList<Integer> list = new LinkedList<Integer>();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }
    
    public void push(int e) {
        list.add(e);
        size++;
    }
    
    public int pop() {
        if (0 == size) {
            throw new RuntimeException("empty");
        }
        int rs = list.get(list.size() - 1);
        list.removeLast();
        size--;
        return rs;
    }
    
    public int peek() {
        if (0 == size) {
            throw new RuntimeException("empty");
        }
        return list.get(list.size() - 1);
    }
    
    public boolean isEmpty() {
        return (0 == size);
    }
    
    

}
