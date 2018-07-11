package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.Node;


/**
 * 
 * @ClassName Problem5
 * @Description 
 * @author pc
 * @Date 2018年7月11日 上午11:13:17
 * @version 1.0.0
 */
public class Problem5 {

    public static void solution(Node head) {
        if (null == head) {
            throw new RuntimeException();
        }
        Stack<Integer> stack = new Stack<Integer>(); 
        while(null != head) {
            stack.add(head.getValue());
            head = head.getNext();
        }
        
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }        
    }
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Node head = new Node(list);
        solution(head);
    }
}
