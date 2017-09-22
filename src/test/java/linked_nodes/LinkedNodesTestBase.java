package linked_nodes;

import utils.Node;
/**
 * 
 * @ClassName LinkedNodesTestBase
 * @Description base class of LinkedNodes Test 
 * @author mark
 * @Date 2017年9月22日 上午9:21:55
 * @version 1.0.0
 */
public class LinkedNodesTestBase {
    
    /**
     * 
     * @Description print all the nodes following "head"
     * @param head
     */
    public void printNodes(Node head) {        
        Node pt = head;
        while (null != pt) {
            System.out.println(pt.getValue());
            pt = pt.getNext();
        }        
    }
    

}
