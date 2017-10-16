package binary_tree;

import utils.BinaryNode;
import utils.Stack;

/**
 * 
 * @ClassName EnumBinaryTree
 * @Description 遍历二叉树
 * @author 叶晓蒙
 * @Date 2017年10月10日 下午12:37:31
 * @version 1.0.0
 */
public class EnumBinaryTree {
    
    /*
     * 运用递归来处理的问题，都可以用非递归方式来实现，
     * 这是因为，递归本质上，就是把信息存储在栈帧里，而这个结构
     * 我们是可以自己实现的
     */
    
    /**
     * 
     * @Description 先序遍历递归法
     */
    public void solution(BinaryNode root) {
        if (null == root) {
            System.out.println("树为空");
            return;
        }        
        System.out.println(root.getValue());
        this.solution(root.left);
        this.solution(root.right);
    }    
        
    /**
     * 
     * @Description 先序遍历循环法
     * @param root
     */
    public void preTraverse(BinaryNode root) {
        
        if (null == root) {
            System.out.println("树为空");
            return;
        }        
        
        // 思路： 首先找到首个中左右都一次性放入栈中的这个节点（待完成）
                
        Stack ls = new Stack();
        
        BinaryNode pt = root;
        
        while (null != pt.left) {
            ls.push(pt.getValue());
            pt = pt.left;
        }
        
        while (null != pt.right) {
            
        }
    }
}
