package linked_nodes;

import org.junit.Before;
import org.junit.Test;

import data_structure_basic.Node;
import zuochengyun_excercises.AddAction;

public class TestAddAction {

    AddAction instance = null;
    
    @Before
    public void init() {
        instance = new AddAction();
    }
    
    
    @Test
    public void testSolution1() {
        
        Node head1 = new Node(9);
        Node pt = head1;
        pt.setNext(new Node(3));
        pt = pt.getNext();
        pt.setNext(new Node(7));
        pt = pt.getNext();
        pt.setNext(new Node(7));
        pt = pt.getNext();
        pt.setNext(new Node(7));
        pt = pt.getNext();
        pt.setNext(new Node(7));
        pt = pt.getNext();
        pt.setNext(new Node(7));
        pt = pt.getNext();
        pt.setNext(new Node(7));
        
        
        Node head2 = new Node(6);
        Node pt2 = head2;
        pt2.setNext(new Node(3));

        Node rs = instance.solution(head1, head2);
        pt = rs;
        while (null != pt) {
            System.out.println(pt.getValue());
            pt = pt.getNext();
        }
    }
    
}
