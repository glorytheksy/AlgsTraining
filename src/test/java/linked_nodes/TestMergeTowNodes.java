package linked_nodes;

import org.junit.Before;
import org.junit.Test;

import utils.Node;
import zcy_linked_nodes.MergeTwoNodes;

public class TestMergeTowNodes extends LinkedNodesTestBase{

    MergeTwoNodes algs = null;
    
    @Before
    public void init() {
        algs = new MergeTwoNodes();
    }
    
    
    @Test
    public void testSolution1() {
        
        Node head = initNode("1,2,3,4,5");  
        Node rs = algs.solution(head);
        this.printNodes(rs);
        
        head = initNode("1,2,3,4,5,6");  
        rs = algs.solution(head);
        this.printNodes(rs);
    }
        
    
}
