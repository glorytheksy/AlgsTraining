package linked_nodes;

import org.junit.Before;
import org.junit.Test;

import utils.Node;
import zcy_linked_nodes.Merge2Nodes;

public class TestMerge2Nodes extends LinkedNodesTestBase {
    
    Merge2Nodes alg = null;
    
    @Before
    public void init() {
        alg = new Merge2Nodes();
    }
    
    @Test
    public void testSolution() {
        
        Node rs = alg.solution(this.initNode("0,2,3,7"), this.initNode("1,3,5,7,9"));
        this.printNodes(rs);
    }
    
}
