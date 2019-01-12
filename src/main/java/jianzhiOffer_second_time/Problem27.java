package jianzhiOffer_second_time;

import data_structure.BinaryNode;

/**
 * @ClassName Problem27
 * @Description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *              要求不能创建任何新的结点，只能调整树中结点指针的指向
 * @author yxmfight
 * @Date 2018年7月17日 下午1:51:42
 * @version 1.0.0
 */
public class Problem27 {
    
    public static BinaryNode solution(BinaryNode node) {
        if (null == node) {
            return null;
        }
        if (null == node.left && null == node.right) {
            return node;
        }
        
        BinaryNode leftNode = null;
        BinaryNode rightNode = null;
        if (null != node.left) {
            leftNode = solution(node.left);
        }
        if (null != node.right) {
            rightNode = solution(node.right);
        }
        
        if (null == leftNode) {
            leftNode = node;
        } else {
            BinaryNode farRight = getFarRight(leftNode);
            farRight.right = node;
            node.left = farRight;
        }
        
        node.right = rightNode;
        if (null != rightNode)
            rightNode.left = node;
        
        return leftNode;
    }
    
    private static BinaryNode getFarRight(BinaryNode node) {
        while (null != node.right) {
            node = node.right;
        }
        
        return node;
    }
    
    public static void main(String[] args) {
        
        BinaryNode root1 = new BinaryNode(1);
        BinaryNode root2 = new BinaryNode(2);
        BinaryNode root3 = new BinaryNode(3);
        BinaryNode root4 = new BinaryNode(4);
        BinaryNode root5 = new BinaryNode(5);
        BinaryNode root6 = new BinaryNode(6);
        BinaryNode root7 = new BinaryNode(7);
        
        root2.left = root1;
        root2.right = root6;

        
        BinaryNode node = solution(root2);
        
        while (null != node) {
            System.out.println(node.value);
            node = node.right;
        }
        
    }
}
