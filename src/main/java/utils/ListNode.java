package utils;

import javax.xml.bind.annotation.W3CDomHandler;
import java.util.Arrays;

public class ListNode {
    
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    
    public static ListNode createListNode(int [] arr) {
        
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode p = res;
        for (int i = 0; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return res.next;
    }
    
    public static void printListNode(ListNode head) {
//        while (null != head) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
//        System.out.println();
        //array转set
    }
  
}
