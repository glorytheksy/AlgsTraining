package jianzhiOffer;

import utils.BinaryNode;

/**
 * @ClassName Problem19
 * @Description 二叉树的镜像
 * @author yxmfi
 * @Date 2018年7月16日 下午2:42:10
 * @version 1.0.0
 */
public class Problem19 {

    public static void solution(BinaryNode t) {
        if (null == t) {
            return;
        }
        
        BinaryNode temp = t.left;
        t.left = t.right;
        t.right = temp;
        
        solution(t.left);
        solution(t.right);        
    }    
}
