package jianzhiOffer_first_time;

import java.util.Stack;

import utils.BinaryNode;

/**
 * 
 * @ClassName findPathOfCertainValue
 * @Description 二叉树中和为某一值的路径
 * @author 叶晓蒙
 * @Date 2018年3月28日 下午5:04:56
 * @version 1.0.0
 */
public class findPathOfCertainValue {

    public Stack<BinaryNode> findPath(BinaryNode head, int target) {      
        if (null == head) {
            return null;
        }
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        int stackSum = 0;
        if(findPath(head, target, stack, stackSum)) {
            return stack;
        } else {
            return null;
        }
    }
    
    /**
     * 
     * @Description head为头的二叉树是否存在和为 target - stackSum 的路径
     * @param head
     * @param target
     * @param stack 存储路径的节点
     * @param stackSum
     * @return
     */
    private boolean findPath(BinaryNode head, int target, Stack<BinaryNode> stack, int stackSum) {
        boolean rs = false;
        if (null == head) {
            return rs;
        }
        
        if (stackSum + head.value == target) {            
            stack.push(head);
            return true;            
        }
        
        stack.push(head);
        stackSum = stackSum + head.value;
        
        boolean isLeftFound = findPath(head.left, target, stack, stackSum);
        if (isLeftFound) {
            return true;
        } else {
            rmvExtra(stack, head);
        }
        
        boolean isRightFound = findPath(head.right, target, stack, stackSum);
        if (isRightFound) {
            return true;
        }
        return rs;
    }
    
    /**
     * 
     * @Description 移除栈内的点一直到 head
     * @param stack
     * @param head
     */
    private void rmvExtra(Stack<BinaryNode> stack, BinaryNode head) {
        if (null == head) {
            return;
        }        
        while(head != stack.peek()) {
            stack.pop();
        }
    }
    
    public static void main(String[] args) {
        BinaryNode t1 = new BinaryNode(8);
        t1.left = new BinaryNode(8);
        t1.right = new BinaryNode(7);
        t1.left.left = new BinaryNode(9);
        t1.left.right = new BinaryNode(2);
        
        BinaryNode t2 = new BinaryNode(8);
        t2.left = new BinaryNode(9);
        t2.right = new BinaryNode(100);
        
        findPathOfCertainValue algs = new findPathOfCertainValue();
        Stack<BinaryNode> rs = algs.findPath(t1, 25);
        
        System.out.println(rs);
        
    }
    
}
