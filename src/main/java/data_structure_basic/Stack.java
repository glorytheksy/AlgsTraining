package data_structure_basic;

import java.util.LinkedList;

public class Stack<T> {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String name;

    protected LinkedList<T> list = new LinkedList<T>();

    protected int size;

    public void push(T element) {
        list.add(element);
        size++;
    }

    public T pop() {
        if (0 == size) {
            throw new RuntimeException();
        }
        size--;
        return list.removeLast();
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public T peek() {
        if (0 == size) {
            throw new RuntimeException("����Ϊ0");
        }
        return list.get(size - 1);
    }

    public int getSize() {
        return size;
    }
}
