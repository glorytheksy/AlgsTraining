package zcy.binary_tree;

import java.util.Stack;

import utils.BinaryNode;

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
    

    /*
     * 总体来说，很难找到递归转非递归(自建栈方式)实现的规律
     * 
     */
            
    /**
     * 
     * @Description 先序遍历打印(中左右)
     * @param root
     */
    public void preTraverse(BinaryNode root) {
        
        if (null == root) {
            System.out.println("树为空");
            return;

        }
        Stack<BinaryNode> s = new Stack<BinaryNode>();
        BinaryNode cur = root;
        s.push(cur);
        
        /* 打印栈顶根节点， 压栈右左 */
        while (!s.isEmpty()) {
            cur = s.pop();
            System.out.println(cur);            
            if ( null != cur.right) {
                s.push(cur.right);
            }
            if (null != cur.left) {
                s.push(cur.left);
            }
        }
    }
    
}
