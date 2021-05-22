package leetcode.algs.kway_merge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName MergeKSortedLists
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author yxmfi
 * @Date 2020年4月4日 下午5:13:57
 * @version 1.0.0
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class MergeKSortedLists {
//    Comparator<ListNode> comparator = new Comparator<ListNode>() {
//        @Override
//        public int compare(ListNode l1, ListNode l2) {
//            return l1.val - l2.val;
//        }
//    };
//
//    public ListNode mergeKLists(ListNode[] lists) {
//        /* init the result list */
//        ListNode res = new ListNode(0); // auxiliary head 
//        ListNode headOfRes = res;
//        /* build que */ 
//        PriorityQueue<ListNode> que = new PriorityQueue<ListNode>(comparator); 
//        for (ListNode node : lists) {
//            if (null == node) {
//                continue;
//            }
//            que.add(node);
//        }                
//        
//        /* build result list */
//        while (!que.isEmpty()) {
//            ListNode cur = que.poll();
//            res.next = cur;
//            res = res.next;
//            
//            if (null == cur.next) {
//                continue;
//            } else {
//                que.add(cur.next);
//            }
//
//        }
//        
//        /* cut the first one */
//        return headOfRes.next;
//    }
//
//    public static void main(String[] args) {
//        int attachArr[] = new int [] {1,2,3,4,5,6};
//        
//        
//    }
    
}
