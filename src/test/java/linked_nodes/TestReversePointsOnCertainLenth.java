package linked_nodes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.Node;
import zcy.linked_nodes.ReversePointsOnCertainLenth;

public class TestReversePointsOnCertainLenth  extends LinkedNodesTestBase{
    
    ReversePointsOnCertainLenth alg = null;
    Node head = null;
    
    @Before
    public void init() {
        alg = new ReversePointsOnCertainLenth();
        head = initNode("0,1,3,4,5,6,8,7");
    }
    
    @After
    public void destroy() {
        ;
    }
    
    @Test
    public void testSolution() {        
        alg.solution(head, 3);
        this.printNodes(head);
    }

}
