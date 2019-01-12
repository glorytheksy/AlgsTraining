package zuochengyun_excercises;

import data_structure.Node;
import data_structure.Stack;

/**
 * 
 * @ClassName AddAction
 * @Description 两个单链表生成相加链表
 * @author 叶晓蒙
 * @Date 2017年9月16日 上午11:17:16
 * @version 1.0.0
 */
public class AddAction {

    public Node solution(Node head1, Node head2) {
        Node rs = null;
        
        /* 生成两个栈 */
        Node p1 = head1;
        Node p2 = head2;
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        while (null != p1) {
            s1.push(p1.getValue());
            p1 = p1.getNext();
        }
        while (null != p2) {
            s2.push(p2.getValue());
            p2 = p2.getNext();
        }
        
        /* 遍历相加 */
        int carry = 0; 
        int digit = s1.pop() + s2.pop() + carry;
        if (10 > digit) {
            carry = 0;
            rs = new Node(digit);
        }else {
            carry = 1;
            rs = new Node (digit - 10); 
        }
        int v1;
        int v2;
        Node temp = null;
        while (0 != s1.getSize() || 0 != s2.getSize()) {
            
            if (0 == s1.getSize()) {
               v1 = 0; 
            } else {
               v1 = s1.pop();
            }
            
            if (0 == s2.getSize()) {
                v2 = 0; 
            } else {
                v2 = s2.pop();
            }            
            digit = v1 + v2 + carry;
            
            if (10 > digit) {
                carry = 0;
                temp = new Node(digit);
            }else {
                carry = 1;
                temp = new Node (digit - 10); 
            }
            temp.setNext(rs);
            rs = temp;            
        }
        if (0 != carry){
            temp = new Node (1);
            temp.setNext(rs);
            rs = temp;
        }
        
        return rs;
        
    }
    
}
