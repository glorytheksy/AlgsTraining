package linked_nodes;

import utils.Node;

/**
 * 
 * @ClassName DeleteRatioPoint
 * @Description 删除链表的中间节点和a/b处的节点
 * @author yxmfi
 * @Date 2017年9月1日 下午1:44:47
 * @version 1.0.0
 */
public class DeleteRatioPoint {
    
    public Node solution1(Node head) {
        if (null == head) {
            throw new RuntimeException();
        }
        
        Node p1 = head;
        Node p2 = head;
                
        while (p1 != p2) {             
            p2 = p2.getNext(); 
            
        }
    }

    public Node solution2(Node head) {
        return null;
    }
    
}
