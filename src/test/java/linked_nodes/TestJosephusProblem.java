package linked_nodes;

import org.junit.Test;

import utils.Node;
import zcy_linked_nodes.JosephusProblem;

public class TestJosephusProblem {
    
    @Test
    public void TestSolution() {
        
        Node head1 = new Node(1);         
        Node p1 = head1;
                
        for (int i = 1; i < 41  ; i++) {
            p1.setNext(new Node(i + 1));
            p1 = p1.getNext();
        }        
        p1.setNext(head1);
        
        JosephusProblem jp = new JosephusProblem();
        Node rs = jp.solution(head1);
        System.out.println(rs.getValue());
    }

}
