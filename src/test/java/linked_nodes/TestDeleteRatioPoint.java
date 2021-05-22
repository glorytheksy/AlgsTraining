package linked_nodes;

import org.junit.Test;

import data_structure_basic.Node;
import zuochengyun_excercises.DeleteRatioPoint;

public class TestDeleteRatioPoint {

    @Test
    public void testSolution1() {
        
        DeleteRatioPoint dp = new DeleteRatioPoint();
        
        Node head1 = new Node(0); 
        Node head2 = new Node(0);
        
        Node p1 = head1;
        Node p2 = head2;
                
        for (int i = 0; i < 4; i++) {
            p1.setNext(new Node(i + 1));
            p1 = p1.getNext();
        }
        
        for (int i = 0; i < 3; i++) {
            p2.setNext(new Node(i + 1));
            p2 = p2.getNext();
        }
        
//        System.out.println(dp.solution1(head1).getValue());
//        System.out.println(dp.solution1(head2).getValue());
    }
    
    
}
