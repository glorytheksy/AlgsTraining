package leetcode.algs.listnode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class TwoSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if ((null == l1 || 0 == l1.val) && null != l2) {
            return l2;
        }
        if ((null == l2 || 0 == l2.val) && null != l1) {
            return l1;
        }
        if ((null == l1 || 0 == l1.val) && (null == l2 || 0 == l2.val)) {
            return new ListNode(0);
        }
        
        
        // 
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode lastNode = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int addition = 0;
        
        while (null != p1 || null != p2) {
            if (null != p1 && null != p2) {
                int curVal = p2.val + p1.val + addition;
                addition = curVal / 10;
                ListNode newNode = new ListNode(curVal % 10);
                lastNode.next = newNode;
                lastNode = newNode;
                p1 = p1.next;
                p2 = p2.next;
            } else if (null != p1 && null == p2) {
                int curVal = p1.val + addition;
                addition = curVal / 10;
                ListNode newNode = new ListNode(curVal % 10);
                lastNode.next = newNode;
                lastNode = newNode;
                p1 = p1.next;
            } else {
                int curVal = p2.val + addition;
                addition = curVal / 10;
                ListNode newNode = new ListNode(curVal % 10);
                lastNode.next = newNode;
                lastNode = newNode;
                p2 = p2.next;
            }
        }
        
        if (1 == addition) {
            ListNode newNode = new ListNode(1);
            lastNode.next = newNode;
            lastNode = newNode;
        }
        
        return dummy.next;


    }
}