package jianzhiOffer_second_time;

import java.util.ArrayList;
import java.util.List;

import utils.BinaryNode;

/**
 * @ClassName Problem25
 * @Description 二叉树中和为某一值的路径
 *              输入一颗二叉树和一整数，打印出二叉树中节点值的和为输入整数的所有路径。
 *              从树的根节点开始往下一直到叶节点经过的结点形成一条路径。
 * 
 * 
 * @author yxmfi
 * @Date 2018年7月17日 上午11:34:52
 * @version 1.0.0
 */
public class Problem25 {
    
    public static void solution(BinaryNode root, int sum) {
        if (null == root) {
            return;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.value);
        printRoad(root, sum - root.value, list);
    }
    
    private static void printRoad(BinaryNode root, int sum, List<Integer> list) {
        if (null == root) {
            return;
        }
        if (null == root.left && null == root.right) {
            if (0 == sum) {
                System.out.println(list);
            }
            return;
        }
        
        if (null != root.left) {
            list.add(root.left.value);
            printRoad(root.left, sum - root.left.value, list);
            list.remove(list.size() - 1);
        }
        if (null != root.right) {
            list.add(root.right.value);
            printRoad(root.right, sum - root.right.value, list);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        BinaryNode root1 = new BinaryNode(1);
        BinaryNode root2 = new BinaryNode(2);
        BinaryNode root3 = new BinaryNode(3);
        BinaryNode root4 = new BinaryNode(4);
        BinaryNode root5 = new BinaryNode(5);
        BinaryNode root6 = new BinaryNode(6);
        BinaryNode root7 = new BinaryNode(7);
        
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        
        solution(root1, 11);
    }

}
