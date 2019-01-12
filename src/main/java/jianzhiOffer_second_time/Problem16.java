package jianzhiOffer_second_time;

import java.util.ArrayList;
import java.util.List;

import utils.Node;

/**
 * 
 * @ClassName Problem16
 * @Description 反转链表
 * @author yxmfi
 * @Date 2018年7月16日 上午10:27:07
 * @version 1.0.0
 */
public class Problem16 {

    public static Node solution(Node head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        
        if (null == head.getNext().getNext()) {
            Node tail = head.getNext();
            tail.setNext(head);
            head.setNext(null);
            return tail;
        }
        
        Node p1 = head;
        Node p2 = head.getNext();
        Node p3 = head.getNext().getNext(); 
        p1.setNext(null);
        while (null != p3.getNext()) {
            p2.setNext(p1);
            p1 = p2;
            p2 = p3;
            p3 = p3.getNext();
        }                
        p2.setNext(p1);
        p3.setNext(p2);        
        return p3;
    }
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        
        Node a = new Node(list);        
        Node b = solution(a);
        b.print();
    }
    
}
