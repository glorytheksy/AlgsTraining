package jianzhiOffer_second_time;

import data_structure_basic.BinaryNode;

/**
 * @ClassName Problem18
 * @Description 树的子结构
 * @author yxmfi
 * @Date 2018年7月16日 下午12:21:06
 * @version 1.0.0
 */
public class Problem18 {

    public static boolean hasSubTree(BinaryNode t1, BinaryNode t2) {
        if (isSubTreeAtHead(t1, t2)) {
            return true;
        } else {
            return hasSubTree(t1.left, t2) || hasSubTree(t1.right, t2);
        }                
        
    }
    
    private static boolean isSubTreeAtHead(BinaryNode t1, BinaryNode t2) {
        if (null == t1 && null == t2) {
            return true;
        }
        if (null == t1 || null == t2) {
            return false;
        }
        
        if (t1.getValue() == t2.getValue()) {
            return isSubTreeAtHead(t1.left, t2.left) && isSubTreeAtHead(t1.right, t2.right);
        } else {
            return false;
        }        
    }
    
    
    
}
