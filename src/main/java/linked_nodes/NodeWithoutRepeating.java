package linked_nodes;

import utils.Node;

/**
 * 
 * @ClassName NodeWithoutRepeating
 * @Description 没有重复元素的链表（generate a node without repeated elements）
 * @author yxmfight
 * @Date 2017年9月26日 下午9:12:48
 * @version 1.0.0
 */
public class NodeWithoutRepeating {
    
    public Node solution(Node head) {
        
        if (null == head) {
            throw new RuntimeException();
        }
        if (null == head.getNext()) {
            return head;
        }
        
        Node pt = head;
        Node pt_next = head.getNext();
        while (null != pt_next) {
            
            while (null != pt_next && pt.getValue() == pt_next.getValue()) {
                pt_next = pt_next.getNext();
                pt.setNext(pt_next);
            }
            
            if (null != pt_next) {
                pt = pt_next;
                pt_next = pt_next.getNext();
            }                        
        }                
        return head;
    }
    

}
