package data_structure_self_impl;

import org.junit.Test;

public class TestMyArrayList {

    
    @Test
    public void testAdd() {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        for (int i = 0; i < 40; i++) {
            list.add(i);
        }
        
        System.out.println(list.get(39));
    }
    
    
}
