package stack_and_queque;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import zuochengyun_excercises.MaxSubMaxtrix;

public class TestMaxSubMatrix {

    
    @Test
    public void testMaxSubArr() {
        
        MaxSubMaxtrix msm = new MaxSubMaxtrix();        
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(0);
        System.out.println(msm.maxSubArr(list));
        
        
    }
    
}
