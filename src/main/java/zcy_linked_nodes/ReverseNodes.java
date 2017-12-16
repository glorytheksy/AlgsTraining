package zcy_linked_nodes;

import utils.DEndNode;
import utils.Node;
/**
 * 
 * @ClassName ReverseNodes
 * @Description 反转单向和双向链表
 * @author yxmfi
 * @Date 2017年9月2日 下午2:02:26
 * @version 1.0.0
 */
public class ReverseNodes {
    
    /**
     * 
     * @Description 反转单链表
     * @param head
     * @return one Node
     */
    public Node solution1(Node head) {
        if (null == head) {
            throw new RuntimeException();
        }
        
        Node p1 = head;
        if (null == p1.getNext()) {
            return p1;
        }
        Node p2 = p1.getNext();
        if (null == p2.getNext()) {
            p1.setNext(null);
            p2.setNext(p1);
            return p2;
        }
        Node p3 = p2.getNext();        
        p1.setNext(null);        
        while (null != p3) {
            p2.setNext(p1);
            
            p1 = p2;
            p2 = p3;
            p3 = p2.getNext();
        }
        p2.setNext(p1);
        return p2;
    }
    
    /**
     * 
     * @Description 反转双链表(相比较单向链表的反转，双向链表的反转需要的辅助条件更少)
     * @param head
     * @return
     */
    public DEndNode solution2(DEndNode head) {
        if (null == head) {
            throw new RuntimeException();
        }
        
        DEndNode p1 = head;
        DEndNode left = null;
        DEndNode right = null;
        while (null != p1.getPost()) {
            left = p1.getPre();
            right = p1.getPost();
            
            p1.setPost(left);
            p1.setPre(right);
            
            p1 = p1.getPre();
        }
        return p1;
    }

}
