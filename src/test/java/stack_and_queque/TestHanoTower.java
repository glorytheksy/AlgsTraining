package stack_and_queque;

import org.junit.Test;

import utils.Stack;
import zcy_stack_and_queue.HanoTower;

public class TestHanoTower {

    
    @Test
    public void testMove() {
        Stack A = new Stack();
        A.push(10);
        A.push(9);
        A.push(8);
        A.push(7);
        A.push(6);
        A.push(5);
        
        Stack B = new Stack();
        Stack C = new Stack();
        
        A.setName("A");
        B.setName("B");
        C.setName("C");
        
                
        HanoTower ht = new HanoTower(A, B, C);
        
        ht.move(6, A, B, C);
        
        System.out.println(C.pop());
        System.out.println(C.pop());
        System.out.println(C.pop());
        System.out.println(C.pop());
        System.out.println(C.pop());
        System.out.println(C.pop());        
    }
    
    
}
