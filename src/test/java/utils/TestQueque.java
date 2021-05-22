package utils;

import org.junit.Before;
import org.junit.Test;

import data_structure_basic.Queue;

public class TestQueque {
    
    @SuppressWarnings("rawtypes")
    Queue q = null;

    @SuppressWarnings("unchecked")
    @Before
    public void init() {
        q = new Queue<Integer>();
        q.add(0);
        q.add(100);
        q.add(10);
        q.add(2);
        q.add(7);        
    }
    
    @Test
    public void test() {
        System.out.println(q.peek());
        System.out.println(q.getSize());
        
        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }
    }
}
