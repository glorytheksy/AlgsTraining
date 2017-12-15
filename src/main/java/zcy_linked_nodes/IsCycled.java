package zcy_linked_nodes;

import org.apache.log4j.Logger;

import utils.Node;

/**
 * 
 * @ClassName IsCycled
 * @Description judge if the nodes is cycled
 * @author yxmfight
 * @Date 2017年9月23日 下午2:56:55
 * @version 1.0.0
 */
public class IsCycled {
    
    private Logger logger = Logger.getLogger(this.getClass());
        
    public Node solution(Node head) {
        if (null == head || null == head.getNext()) {
            return null;
        }
                
        Node p1 = head;
        Node p2 = head;
        
        while (null != p1 && null != p2 && null != p2.getNext()) {  
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            
            if (p1 == p2) {
                return this.getCrossPoint(head, p1);
            }            
        }
                
        return null;
    }
    
    private Node getCrossPoint(Node head, Node meetPoint) {
        if (null == head || null == meetPoint) {
            throw new RuntimeException();
        }
        
        Node p1 = head;
        Node p2 = meetPoint;
        
        while (null != p1 && null != p2) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        logger.error("get crorss point failed!");
        return null;
        
    }

}
