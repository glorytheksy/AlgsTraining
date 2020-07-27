package jianzhiOffer_second_time;

import exercises.TreeNode;

/**
 * @ClassName Problem27
 * @Description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *              要求不能创建任何新的结点，只能调整树中结点指针的指向
 * @author yxmfight
 * @Date 2018年7月17日 下午1:51:42
 * @version 1.0.0
 */
public class Problem27 {
    
    public boolean isSymmetric(TreeNode root) {
    	if (null == root) {
    		return true;
    	}
    	return this.symm(root.left, root.right);
    }
    
    private boolean symm(TreeNode lt_root, TreeNode rt_root) {
    	if (null == lt_root && null == rt_root) {
    		return true;
    	}
    	if (null == lt_root || null == rt_root) {
    		return false;
    	}
    	
    	if (lt_root.val == rt_root.val) {
    		return this.symm(lt_root.left, rt_root.right) && this.symm(lt_root.right, rt_root.left);
    	} else {
    		return false;
    	}
    	
    }
    
    
    public boolean isLeaf(TreeNode root) {
    	if (root.left == null && root.right == null) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public static void main(String[] args) {
        
        
    }
}
