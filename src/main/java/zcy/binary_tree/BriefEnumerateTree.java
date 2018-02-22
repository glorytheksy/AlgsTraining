package zcy.binary_tree;

import utils.BinaryNode;
import utils.Queue;

/**
 * 
 * @ClassName BriefEnumerateTree
 * @Description 以便于理解的方式遍历打印二叉树
 * @author yxmfight
 * @Date 2017年12月11日 下午9:07:05
 * @version 1.0.0
 */
public class BriefEnumerateTree {
    /**
     * 
     * @Description 考虑一层一层的打印，先进先出，使用队列
     * @param root
     */
    public void solution_stand1(BinaryNode root) {   
        
        Queue<BinaryNode> que = new Queue<BinaryNode>();
        que.add(root);
        
        while(!que.isEmpty()) {
            
            BinaryNode temp = que.poll();
            System.out.println(temp.value);
            if (null != temp.left) {
                que.add(temp.left);
            }
            if (null != temp.right) {
                que.add(temp.right);
            }
            
        }
    }
    
}
