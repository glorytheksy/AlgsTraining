package linked_nodes;

import org.junit.Before;
import org.junit.Test;

import utils.Node;
import zcy_linked_nodes.Seperation;

public class TestSeperation {

    Seperation sp = null;
    
    @Before
    public void init() {
        sp = new Seperation();
    }
    
    
    @Test
    public void testSolution1() {
        
        Node head = new Node(9);
        Node pt = head;
        pt.setNext(new Node(0));
        pt = pt.getNext();
        pt.setNext(new Node(4));
        pt = pt.getNext();
        pt.setNext(new Node(5));
        pt = pt.getNext();
        pt.setNext(new Node(1));
        pt = pt.getNext();
        
        Node rs = sp.solution1(head, 3);
        pt = rs;
        while (null != pt) {
            System.out.println(pt.getValue());
            pt = pt.getNext();
        }
    }
}
