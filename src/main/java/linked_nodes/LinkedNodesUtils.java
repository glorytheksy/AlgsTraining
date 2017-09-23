package linked_nodes;

import org.apache.log4j.Logger;

import utils.Node;

public class LinkedNodesUtils{
    
    private static Logger logger = Logger.getLogger(LinkedNodesUtils.class);
    
    /**
     * 
     * @Description 将一个node指针后移n步(move a node pointer n steps forward)
     * @param head
     * @param n
     * @return
     */
    public static Node moveForward(Node head, int n) {
        if (null == head) {
            logger.warn("the head is null!");
            return null;
        }
        Node rs = head;
        
        for (int i = 0; i < n; i++) {
            rs = rs.getNext();
            if (null == rs) {
                logger.warn("pointer overpass the nodes!");
                return null;
            }
        }
        return rs;
    }


}
