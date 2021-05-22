package jianzhiOffer_first_time;

import data_structure_basic.BinaryNode;

/**
 * @ClassName ReBuildBinaryTree
 * @Description 重建二叉树
 * @author 叶晓蒙
 * @Date 2018年3月12日 下午2:20:24
 * @version 1.0.0
 */
public class ReBuildBinaryTree {
    
    /**
     * @Description 先序遍历序列重建二叉树(我之前并不知道可以依靠序列去重建二叉树)
     * @param arr
     * @return
     */
    public BinaryNode rebuild(int arr[]) {
        return rebuild(arr, 0, arr.length - 1);
    }
    
    /**
     * @Description 
     * @param arr
     * @param pos
     * @param node
     * @return
     */
    private BinaryNode rebuild(int arr[], int head, int end) {
        BinaryNode headNode = new BinaryNode(arr[head]);
        if (head == end) {
            return headNode;
        }
        if (head > end) {
            return null;
        }        
        
        int leftEnd = findLeftEnd(arr, head);
        headNode.left = rebuild(arr, head + 1, leftEnd);
        headNode.right = rebuild(arr, leftEnd + 1, end);
        return headNode;
    }
    
    private int findLeftEnd(int [] arr, int start) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] > arr[start]) {
                return i - 1;
            }
        }
        return start;
    }
    
    public static void main(String[] args) {
        
        int [] arr = new int [] {1, 2, 4,7,3,5,6,8};
        ReBuildBinaryTree rebuild = new ReBuildBinaryTree();
        BinaryNode tree = rebuild.rebuild(arr);
        TreeEnumerate.preorder(tree);
    }
    
}
