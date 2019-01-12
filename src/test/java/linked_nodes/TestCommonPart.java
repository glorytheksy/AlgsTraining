package linked_nodes;

import org.junit.Test;

import data_structure.Node;
import zuochengyun_excercises.CommonPart;

public class TestCommonPart {

    @Test
    public void testCommonPart() {
        
        CommonPart cp = new CommonPart();
        
        Node head1 = new Node(0); 
        Node head2 = new Node(3);
        
        Node p1 = head1;
        Node p2 = head2;
                
        for (int i = 0; i < 3; i++) {
            p1.setNext(new Node(i + 1));
            p1 = p1.getNext();
        }
        
        for (int i = 0; i < 6; i++) {
            p2.setNext(new Node(i + 4));
            p2 = p2.getNext();
        }
        
        for (int i = 0; i < 6; i++) {
            p2.setNext(new Node(i + 100));
            p1.setNext(p2.getNext());
            
            p1 = p1.getNext();
            p2 = p2.getNext();
            
        }
        
        cp.solution(head1, head2);
        
    }
    
}
