package stack_and_queque;

import java.util.ArrayList;

import org.junit.Test;

import data_structure.BinaryNode;
import zuochengyun_excercises.MaxTree;

public class TestMaxTree {
    
    
    @Test
    public void testltBigMap() {
        MaxTree mt = new MaxTree();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(9);
        list.add(101);
        list.add(92);
        list.add(2);
        list.add(5);
        list.add(10);
        list.add(8);
//        System.out.println(mt.ltBigMap(list));
        System.out.println(mt.rtBigMap(list));
        
        BinaryNode bn = mt.solution(list);
    }
}
