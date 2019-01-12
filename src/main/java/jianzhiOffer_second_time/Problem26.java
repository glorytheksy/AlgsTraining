package jianzhiOffer_second_time;

import java.util.HashMap;
import java.util.Map;

import data_structure.ComplexListNode;

/**
 * @ClassName Problem26
 * @Description 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。求一个复制体。
 * @author yxmfi
 * @Date 2018年7月17日 下午12:52:27
 * @version 1.0.0
 */
public class Problem26 {
    
    public static ComplexListNode solution(ComplexListNode node) {
        if (null == node) {
            return null;
        }
        
        Map<ComplexListNode, ComplexListNode> posMap = new HashMap<ComplexListNode, ComplexListNode>(); 
        
        ComplexListNode p1 = node;
        ComplexListNode p2 = new ComplexListNode(p1.getValue());
        posMap.put(p1, p2);
        ComplexListNode node2 = p2;
                        
        while (null != p1.getNext() && !posMap.containsKey(p1.getNext())) {
            if (posMap.containsKey(p1)) {
                break;
            }
            
            ComplexListNode newNode = new ComplexListNode(p1.getNext().getValue());            
            posMap.put(p1.getNext(), newNode);
            p2.setNext(newNode);
            
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        
        p1 = node;
        p2 = node2;
        
        while (null != p1.getNext() && !posMap.containsKey(p1.getNext())) {
            if (posMap.containsKey(p1)) {
                break;
            }
            
            ComplexListNode sib = posMap.get(p1);
            p2.setSibling(sib);
            
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        
        return node2;
    }
    
}
