package zuochengyun_excercises;

import data_structure.Node;

/**
 * 
 * @ClassName DeleteRatioPoint
 * @Description 删除链表的中间节点和a/b处的节点
 * @author yxmfi
 * @Date 2017年9月1日 下午1:44:47
 * @version 1.0.0
 */
public class DeleteRatioPoint {
    
    /**
     * 
     * @Description 求中间节点
     * @param head
     * @return
     */
    public void solution1(Node head) {
        if (null == head) {
            throw new RuntimeException();
        }
        
        Node p1 = head;
        Node p2 = null;
        if (null != head.getNext()) {
            p2 = head.getNext(); 
        }            
        else {
            head = null;
        }            
        
        while (null != p2.getNext() && null != p2.getNext().getNext()) {             
            p2 = p2.getNext().getNext(); 
            p1 = p1.getNext();
        }
        p1.setNext(p1.getNext().getNext());
    }

    /**
     * 
     * @Description 求a/b处节点
     * @param head
     * @return
     */
    public Node solution2(Node head, int a, int b) {
        if (null == head) {
            throw new RuntimeException();
        }
        
        if (a < 0 || b < 0 || a > b) {
            throw new RuntimeException();
        }
        return null;
    }
    
}
