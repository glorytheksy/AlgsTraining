package linked_nodes;

import org.junit.Before;
import org.junit.Test;

import utils.Node;
import zcy.linked_nodes.Palindrome;

public class TestPalindrome {
    
    Palindrome pd = null;
    
    @Before
    public void init() {
        pd = new Palindrome();
    }
    
    @Test
    public void testSolution() {
        Node head = new Node(0); 
        Node pt = head;
        
        for (int i = 0; i < 3; i++) {
            pt.setNext(new Node(i + 1));
            pt = pt.getNext();
        }
        
        for (int i = 4; i > 0; i--) {
            pt.setNext(new Node(i - 1));
            pt = pt.getNext();
        }
        
//        for (int i = 3; i > 0; i--) {
//            pt.setNext(new Node(i - 1));
//            pt = pt.getNext();
//        }
        
        System.out.println(pd.solution(head));
        
    }
    
}
