package jianzhiOffer_second_time;

import java.util.ArrayList;
import java.util.List;

import data_structure_basic.BinaryNode;

/**
 * @ClassName Problem6
 * @Description
 * @author pc
 * @Date 2018年7月11日 下午12:23:30
 * @version 1.0.0
 */
public class Problem6 {

    public static BinaryNode solution(List<Integer> pre, List<Integer> mid) {
        if (null == pre || null == mid) {
            return null;
        }
        if (pre.size() != mid.size()) {
            throw new RuntimeException("sequence num should be identical!");
        }
        if (pre.isEmpty()) {
            return null;
        }
        if (1 == pre.size()) {
            return new BinaryNode(pre.get(0));
        }

        BinaryNode head = new BinaryNode(pre.get(0));
        BinaryNode left = null;
        BinaryNode right = null;

        int midHeadPos = searchPos(mid, pre.get(0));
        int preLeftTail = midHeadPos;
        left = solution(pre.subList(1, preLeftTail + 1), mid.subList(0, midHeadPos));
        right = solution(pre.subList(preLeftTail + 1, pre.size()), mid.subList(midHeadPos + 1, mid.size()));

        head.left = left;
        head.right = right;
        return head;
    }

    private static int searchPos(List<Integer> list, int num) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> pre = new ArrayList<Integer>();

        List<Integer> mid = new ArrayList<Integer>();

        pre.add(1);
        pre.add(2);
        pre.add(4);
        pre.add(7);
        pre.add(3);
        pre.add(5);
        pre.add(6);
        pre.add(8);
        mid.add(4);
        mid.add(7);
        mid.add(2);
        mid.add(1);
        mid.add(5);
        mid.add(3);
        mid.add(8);
        mid.add(6);

        // pre.add(1);
        // pre.add(2);
        // pre.add(4);
        // mid.add(2);
        // mid.add(1);
        // mid.add(4);

        BinaryNode head = solution(pre, mid);
//        BinaryNode.preTraverse(head);
         BinaryNode.midTraverse(head);
    }
}
