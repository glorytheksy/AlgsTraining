package jianzhiOffer;

import javax.management.RuntimeErrorException;

import utils.Node;

/**
 * 
 * @ClassName Problem15
 * @Description 链表中倒数第k个节点 
 * 
 * @author yxmfight
 * @Date 2018年7月16日 上午9:32:31
 * @version 1.0.0
 */
public class Problem15 {

    public static Node solution(Node head, int k) {
        if (null == head) {
            throw new RuntimeException("input is null");
        }
        if (k <= 0) {
            throw new RuntimeException("input is error");
        }
        
        Node p = head;
        for (int i = 0; i < k - 1; i++) {
            p = p.getNext();
        }
        if (null == p) {
            throw new RuntimeException("error");
        }
        
        while(null != p) {
            head = head.getNext();
            p = p.getNext();
        }        
        return head;
    }
    
    
}
