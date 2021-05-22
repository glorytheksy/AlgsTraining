package linked_nodes;

import org.junit.Before;
import org.junit.Test;

import data_structure_basic.Node;
import zuochengyun_excercises.ReverseNodes;

public class TestReverseNodes extends LinkedNodesTestBase{

    ReverseNodes rn = null;
    
    @Before
    public void init() {
        rn = new ReverseNodes();
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
        
        Node rs = rn.solution1(head);
        this.printNodes(rs);
    }
        
    
}
