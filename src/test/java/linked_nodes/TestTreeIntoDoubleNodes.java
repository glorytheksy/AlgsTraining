package linked_nodes;

import org.junit.Before;
import org.junit.Test;

import utils.BinaryNode;
import utils.DEndNode;

public class TestTreeIntoDoubleNodes extends LinkedNodesTestBase{

    TreeIntoDoubleNodes alg = null;
    
    @Before
    public void init() {
        alg = new TreeIntoDoubleNodes();
    }
    
    @Test
    public void testSolution() {
        
        BinaryNode left = new BinaryNode(1);
        BinaryNode mid = new BinaryNode(2);
        BinaryNode right = new BinaryNode(3);
        
        mid.left = left;
        mid.right = right;
        
        DEndNode rs = alg.solution(mid);
        
        DEndNode pt = rs;
        while (null != pt) {
            System.out.println(pt.getValue());
            pt = pt.getPost();
        }

    }
}
