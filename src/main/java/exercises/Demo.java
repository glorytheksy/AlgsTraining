package exercises;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Demo {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode p1 = head;
        if (null == p1.next) {
            return p1;
        }

        ListNode p2 = head.next;
        ListNode pt = null;

        while (null != p2 && p1.val == p2.val) {
            pt = p2;
            while (null != pt &&
                    pt.val == p1.val) {
                pt = pt.next;
            }
            
            if (null == pt) {
                return null;
            } else {
                p1 = pt;
                p2 = p1.next;
                head = p1;
            }
        }
        
        while (p2 != null) {
            pt = p2.next;
            if (null == pt) {
                break;
            }
            while (null != pt && 
                    pt.val == p2.val) {
                pt = pt.next;
            }
            if (null == pt) {
                p1.next = null;
                return head;
            }
            
            p1.next = pt;
            p2 = pt;
            
        }
        return head;
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        ListNode head = new ListNode(1);
        ListNode tail = head;
        
        tail.next = new ListNode(2);
        tail = tail.next;

        tail.next = new ListNode(3);
        tail = tail.next;

        tail.next = new ListNode(3);
        tail = tail.next;

        tail.next = new ListNode(4);
        tail = tail.next;

        tail.next = new ListNode(4);
        tail = tail.next;

        tail.next = new ListNode(5);
        tail = tail.next;

        ListNode t = d.deleteDuplicates(head);
        while (null != t) {
            System.out.println(t.val);
            t = t.next;
        }
    }

}
