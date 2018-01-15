package stack_and_queque;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import zcy.stack_and_queue.WindowMaxValue;

public class TestWindowMaxValue {

    @Test
    public void testSolution() {
        
        WindowMaxValue ww = new WindowMaxValue();                
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(3);
        list.add(6);
        list.add(7);
        
        System.out.println(ww.solution(list, 3));
    }
    
}
