package linked_nodes;

import utils.Node;
import utils.Queque;
import utils.Stack;

public class Seperation {
    
    
    /**
     * 
     * @Description 保持有序的情况
     * @param head
     * @param sep
     * @return
     */
    public Node solution1(Node head, int sep) {
        
        Node rs = new Node(0);
                
        if (null == head) {
            throw new RuntimeException();
        }
        
        Queque smal = new Queque();
        Stack eql = new Stack();
        Queque big = new Queque();
        
        Node pt = head;
        
        while (null != pt) {
            if (sep > pt.getValue()) 
                smal.push(pt.getValue());
            else if (sep < pt.getValue())
                big.push(pt.getValue());
            else 
                eql.push(pt.getValue());            
            pt = pt.getNext();
        }
        
        pt = rs;
        
        while(!smal.isEmpty()) {
            pt.setNext(new Node(smal.poll()));
            pt = pt.getNext();
        }
        
        while (!eql.isEmpty()) {
            pt.setNext(new Node(eql.pop()));
            pt = pt.getNext();
        }

        while (!big.isEmpty()) {
            pt.setNext(new Node(big.poll()));
            pt = pt.getNext();
        }
        
        return rs.getNext();
    }

}
