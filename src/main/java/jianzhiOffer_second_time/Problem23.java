package jianzhiOffer_second_time;

import data_structure.BinaryNode;
import data_structure.Queue;

/**
 * @ClassName Problem23
 * @Description 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * @author yxmfi
 * @Date 2018年7月17日 上午10:09:43
 * @version 1.0.0
 */
public class Problem23 {
    
    public static void solution(BinaryNode root) {
        if (null == root) {
            return;
        }
        
        Queue<BinaryNode> que = new Queue<BinaryNode>();
        que.add(root);
        
        while(!que.isEmpty()) {
            BinaryNode bnode = que.poll();
            System.out.println(bnode.value);
            
            if (null != bnode.left) {
                que.add(bnode.left);
            }
            if (null != bnode.right) {
                que.add(bnode.right);
            }
        }
    }
    
    
    
    
}
