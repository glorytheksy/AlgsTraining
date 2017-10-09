package linked_nodes;

import utils.Node;

/**
 * 
 * @ClassName MergeTwoNodes
 * @Description 按照左右半区的方式重新组合单链表
 * @author 叶晓蒙
 * @Date 2017年10月9日 上午8:33:47
 * @version 1.0.0
 */
public class MergeTwoNodes {

    public Node solution(Node head) {        
        if (null == head) {
            return null;
        }
        
        Node rs = new Node(-1); 
        Node rsPt = rs;
        
        Node p1 = head;
        Node mid = getMiddleNode(head); 
        Node p2 = mid;
        while (mid != p1) {
            rsPt.setNext(new Node(p1.getValue()));
            rsPt = rsPt.getNext();
            rsPt.setNext(new Node(p2.getValue()));
            rsPt = rsPt.getNext();
            
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        
        if (null == p2) {
            ;
        }
        else {
            rsPt.setNext(new Node(p2.getValue()));
        }                
        return rs.getNext();
    }
    
    
    /**
     * 
     * @Description 倍速法求中点
     * @param head
     * @return
     */
    private Node getMiddleNode(Node head) {
        
        if (null == head) {
            return null;
        }
        
        Node p1 = head;
        Node p2 = head;
        
        while (null != p2 && null != p2.getNext()) {
            
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            
        }
        return p1;
    }
    
}
