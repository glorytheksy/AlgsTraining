package linked_nodes;

import org.junit.Before;
import org.junit.Test;

import utils.Node;

public class TestNodeWithoutRepeating extends LinkedNodesTestBase {
    
    NodeWithoutRepeating alg = null;
    
    @Before
    public void init() {
        alg = new NodeWithoutRepeating();
    }
    
    @Test
    public void testSolution() {
        Node head = this.initNode("1,1,1,1,1,1");
        this.printNodes(alg.solution(head));
        
        head = this.initNode("1,2,1,1,1,1");
        this.printNodes(alg.solution(head));
    }

}
