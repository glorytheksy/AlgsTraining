package jianzhiOffer_first_time;

import data_structure_basic.BinaryNode;

/**
 * @ClassName TreeSubStructure
 * @Description 树的子结构
 * @author 叶晓蒙
 * @Date 2018年3月21日 下午4:21:37
 * @version 1.0.0
 */
public class TreeSubStructure {
    
    /**
     * 该题目关键在于把问题拆成子问题
     * 
     * 
     * 
     */
    
    
    public boolean hasSubStruct(BinaryNode t1, BinaryNode t2) {
        if (null == t2) {
            return true;
        }
        if (null == t1) {
            return false;
        }       
        
        if (t1.getValue() == t2.getValue()) {            
            if (isSub(t1, t2)) {
                return true;
            } else {
                return hasSubStruct(t1.left, t2) || hasSubStruct(t1.right, t2);
            }
        } else {
            return hasSubStruct(t1.left, t2) || hasSubStruct(t1.right, t2);
        }
    }
    
    
    private boolean isSub(BinaryNode father, BinaryNode son) {
        if (null == father && null == son) {
            return true;
        }
        if (null != father && null == son) {
            return true;
        }
        if (null == father && null != son) {
            return false;
        }
        
        if (father.value == son.value) {
            return isSub(father.left, son.left) && isSub(father.right, son.right);
        } else {
            return false;
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
        
        TreeSubStructure algs = new TreeSubStructure();
        boolean has = algs.hasSubStruct(t1, t2);
        System.out.println(has);
    }
    
}
