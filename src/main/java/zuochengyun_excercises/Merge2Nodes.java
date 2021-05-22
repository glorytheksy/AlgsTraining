package zuochengyun_excercises;

import data_structure_basic.Node;

/**
 * 
 * @ClassName Merge2Nodes
 * @Description 以一定的顺序合并两个有序链表 (merge two linked nodes with a certain order, return the nodes head)
 * @author yxmfight
 * @Date 2017年10月1日 上午9:55:57
 * @version 1.0.0
 */
public class Merge2Nodes {

    /**
     * 
     * @Description 由于两个链表本身就是有序的，所以可以用逐个取出比较的方法
     *              for that the two nodes are ordered already, we can use the following method
     * @param head1
     * @param head2
     * @return
     */
    public Node solution(Node head1, Node head2) {
        Node rs = new Node(-1);
        
        if (null == head1 && null == head2) {
            throw new RuntimeException();
        }
        
        Node p1 = head1;
        Node p2 = head2;
        Node rsPt = rs;
        
        while (null != p1 || null != p2) {
            
            /*
             * 元操作就2种，但是写成4个分类便于直观理解
             */
            if (null != p1 && null != p2) {
                if (p1.getValue() < p2.getValue()) {
                    rsPt.setNext(new Node(p1.getValue()));
                    rsPt = rsPt.getNext();
                    p1 = p1.getNext();
                } 
                else {
                    rsPt.setNext(new Node(p2.getValue()));
                    rsPt = rsPt.getNext();
                    p2 = p2.getNext();
                }   
            }
            else if (null == p1) {
                rsPt.setNext(new Node(p2.getValue()));
                rsPt = rsPt.getNext();
                p2 = p2.getNext();
            }            
            else {
                rsPt.setNext(new Node(p1.getValue()));
                rsPt = rsPt.getNext();
                p1 = p1.getNext();
            }
                                            
        }
        
        Node realRs = rs.getNext();
        rs = null; // in case leak                
        return realRs;
    }
    
    /**
     * 
     * @Description 在head1或者head2内操作，这里就不实现了
     * @param head1
     * @param head2
     * @return
     */
    public Node solution_2(Node head1, Node head2) {
        return null;
    }
    
}
