package exercises;

import utils.CommonUtils;
import utils.ListNode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Test {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = preorder.length;
        return this.buildTree(preorder, 0, l - 1, inorder, 0, l - 1);
    }

    public TreeNode buildTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        TreeNode head = new TreeNode(preorder[l1]);
        TreeNode left = null;
        TreeNode right = null;
        if (l1 == r1) {
            return head;
        }

        int pos = -1;
        for (int i = l2; i <= r2; i++) {
            if (head.val == inorder[i]) {
                pos = i;
                break;
            }
        }

        if (l2 == pos) {
            right = this.buildTree(preorder, r1 - (r2 - (pos + 1)), r1, inorder, pos + 1, r2);
        } else if (r2 == pos) {
            left = this.buildTree(preorder, l1 + 1, l1 + 1 + (pos - 1 - l2), inorder, l2, pos - 1);
        } else {
            left = this.buildTree(preorder, l1 + 1, l1 + 1 + (pos - 1 - l2), inorder, l2, pos - 1);
            right = this.buildTree(preorder, r1 - (r2 - (pos + 1)), r1, inorder, pos + 1, r2);
        }

        head.left = left;
        head.right = right;
        return head;
    }

    public static void main(String[] args) {
        int [] pre = {3,9,20,15,7};
        int [] in = {9,3,15,20,7};
        
        Test test = new Test();
        TreeNode res = test.buildTree(pre, in);
        
    }
}


