package linked_nodes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data_structure_basic.Node;
import junit.framework.Assert;
import zuochengyun_excercises.IsCycled;

public class TestIsCycled   extends LinkedNodesTestBase{
    
    IsCycled alg = null;
    Node head = null;
    
    @Before
    public void init() {
        alg = new IsCycled();        
        
        head = new Node (-1);
        Node pt = head;
        
        pt.setNext(new Node(0));
        pt = pt.getNext();
        pt.setNext(new Node(4));
        pt = pt.getNext();
        pt.setNext(new Node(5));
        pt = pt.getNext();
        pt.setNext(new Node(1));
        pt = pt.getNext();
        
        Node mid = new Node(10);
        
        pt.setNext(mid);
        pt = pt.getNext();
        pt.setNext(new Node(12));
        pt = pt.getNext();
        pt.setNext(new Node(14));
        pt = pt.getNext();
        pt.setNext(new Node(15));
        pt = pt.getNext();
        pt.setNext(mid);
        
    }
    
    @After
    public void destroy() {
        ;
    }
    
    @Test
    public void testIsCycled() {
        
        Node rs = alg.solution(head);
        System.out.println(rs.getValue());
        Assert.assertTrue(10 == rs.getValue());
    }

}
