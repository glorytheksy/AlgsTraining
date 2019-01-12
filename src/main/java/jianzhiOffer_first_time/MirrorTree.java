package jianzhiOffer_first_time;

import data_structure.BinaryNode;

/**
 * 
 * @ClassName MirrorTree
 * @Description 镜像树
 * @author 叶晓蒙
 * @Date 2018年3月22日 上午8:57:11
 * @version 1.0.0
 */
public class MirrorTree {

    public BinaryNode getMirror(BinaryNode tree) {        
        if (null == tree) {
            return null;
        }        
        BinaryNode head = new BinaryNode(tree.value);
        head.left = getMirror(tree.right);
        head.right = getMirror(tree.left);        
        return head;
    }
    
    
    public static void main(String[] args) {
        BinaryNode t1 = new BinaryNode(8);
        t1.left = new BinaryNode(8);
        t1.right = new BinaryNode(7);
        t1.left.left = new BinaryNode(9);
        t1.left.right = new BinaryNode(2);
        
        MirrorTree mirror = new MirrorTree();
        mirror.getMirror(t1);
    }
    
}
