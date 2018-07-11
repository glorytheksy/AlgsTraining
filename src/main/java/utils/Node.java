package utils;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int value;
    
    private Node next;
        
    public Node() {
    }
    
    public Node(List<Integer> list) {
        if (null == list) {
            throw new RuntimeException("input is null");
        }
        value = list.get(0);
        if (list.size() > 1) {
            Node node = new Node();
            this.setNext(node);
            
            for (int i = 1; i < list.size() - 1; i++) {
                node.setValue(list.get(i));
                node.setNext(new Node());
                node = node.getNext();
            }
            node.setValue(list.get(list.size() - 1));            
        }                
    }
    
    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        Node node = new Node(list);
        Node head = node;
        while (null != head) {
            System.out.println(head.getValue());
            head = head.next;
        }
    }
    
}
