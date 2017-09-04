package utils;

import org.junit.Before;
import org.junit.Test;

public class TestQueque {
    
    Queque q = null;

    @Before
    public void init() {
        q = new Queque();
        q.push(0);
        q.push(100);
        q.push(10);
        q.push(2);
        q.push(7);
        
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
