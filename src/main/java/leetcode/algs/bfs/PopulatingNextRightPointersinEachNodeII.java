package leetcode.algs.bfs;

import utils.CommonUtils;

import java.util.*;




public class PopulatingNextRightPointersinEachNodeII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {

        Queue<Node> que = new LinkedList<Node>();

        Node last = new Node();
        boolean isLastInUpper = true;
        boolean isCurTail;
        ((LinkedList<Node>) que).push(root);
        while (!que.isEmpty()) {

            Node node = ((LinkedList<Node>) que).pop();
            if (que.isEmpty()) {
                isCurTail = true;
            } else {
                isCurTail = false;
            }

            if (isLastInUpper) {
                last.next = null;
            } else {
                last.next = node;
            }

            if (isCurTail) {
                isLastInUpper = true;
            } else {
                isLastInUpper = false;
            }

            last = node;
            if (null != node.left) {
                ((LinkedList<Node>) que).push(node.left);
            }
            if (null != node.right) {
                ((LinkedList<Node>) que).push(node.right);
            }
        }
        last.next = null;
        return root;
    }



}
