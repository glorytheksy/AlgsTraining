package jianzhiOffer_first_time;

import data_structure_basic.BinaryNode;

/**
 * 
 * @ClassName TreeEnumerate
 * @Description 遍历树
 * @author 叶晓蒙
 * @Date 2018年3月12日 下午3:33:57
 * @version 1.0.0
 */
public class TreeEnumerate {

    public static void preorder(BinaryNode node) {
        if (null == node) {
            return;
        }
        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    
    
    
}
