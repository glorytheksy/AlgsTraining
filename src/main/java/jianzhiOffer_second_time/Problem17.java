package jianzhiOffer_second_time;

import java.util.ArrayList;
import java.util.List;

import data_structure.Node;

/**
 * @ClassName Problem17
 * @Description 合并两个排序得链表
 * @author yxmfi
 * @Date 2018年7月16日 上午11:01:32
 * @version 1.0.0
 */
public class Problem17 {

    /**
     * @Description 
     * @param head1 被插入
     * @param head2
     * @return
     */
    public static Node solution(Node head1, Node head2) {
        if (null == head1) {
            return head2;
        }
        if (null == head2) {
            return head1;
        }
        
        Node p1 = head1;
        Node p2 = head2;
        
        while (null != p2) {
            Node node = null;
            if (p1.getValue() > p2.getValue()) {
                node = new Node(p1.getValue()); 
                p1.setValue(p2.getValue());                                               
            } else {                
                while (null != p1.getNext()) {
                    if (p1.getNext().getValue() > p2.getValue()) {
                        break;
                    }
                    p1 = p1.getNext();
                }                
                node = new Node(p2.getValue());
            }
            node.setNext(p1.getNext());
            p1.setNext(node);
            p1 = node.getNext();
            p2 = p2.getNext();             
            if (null == p1) {
                p1 = node;
            }
        }
        
        return head1;        
    }
    
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);
        
        Node head1 = new Node(list1);   
        Node head2 = new Node(list2);   
        
        Node x = solution(head1, head2);
        x.print();
        
    }
    
}
