package binary_tree;

import utils.BinaryNode;
import utils.Stack;

/**
 * 
 * @ClassName OutliersOfTree
 * @Description 打印树的边界值
 * @author 叶晓蒙 
 * @Date 2017年10月16日 上午8:47:13
 * @version 1.0.0
 */
public class OutliersOfTree {
    
    /* 方法一  比较直接的方法，从图中总结规律  */
    
    /**
     * 
     * @Description 标准一
     * @param root
     */
    public void solution_stand1(BinaryNode root) {        
        if (null == root) {
            return;
        }
        
        BinaryNode pt = root;
        BinaryNode lt = pt.left;
        BinaryNode rt = pt.right;
        
        // 打印头
        System.out.println(root.getValue());
        
        /* 打印左半边 */
        while (! (hasNoChild(lt) && hasNoChild(rt)) ) { // 是否到底部了
            if (null != lt) {
                System.out.println(lt.getValue());
            } else {  
                System.out.println(rt.getValue());
            }
            if (hasNoChild(rt)) pt = lt;
            else pt = rt;            
            lt = pt.left;
            rt = pt.right;
        }
        if (null != lt)
            System.out.println(lt);
        if (null != rt)
            System.out.println(rt);
        
        /* 打印右半边 */
        Stack s = new Stack();
        while (! (hasNoChild(lt) && hasNoChild(rt)) ) { // 是否到底部了
            if (null != rt) {     
                s.push(lt.getValue());
            } else {
                s.push(lt.getValue());
            }
            if (hasNoChild(rt)) pt = lt;
            else pt = rt;
            lt = pt.left;
            rt = pt.right;
        }
        if (null != rt)
            s.push(rt.getValue());
        if (null != lt)
            s.push(lt.getValue());
        
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    
    
    /**
     * 
     * @Description 标准二
     * @param root
     */
    public void solution_stand2(BinaryNode root) {        
        if (null == root) {
            return;
        }
        
        BinaryNode pt = root;
        BinaryNode lt = pt.left;
        BinaryNode rt = pt.right;
        
        // 打印头
        System.out.println(root.getValue());
        
        /* 打印左半边 */
        while (! (hasNoChild(lt) && hasNoChild(rt)) ) { // 是否到底部了
            if (null != lt) {
                System.out.println(lt.getValue());
                pt = lt;
            } else {
                if (null != rt.left) {
                    System.out.println(rt.getValue());
                }
                pt = rt;
            }
            lt = pt.left;
            rt = pt.right;
        } 
        
        /* 打印右半边 */
    }
    
    private boolean hasNoChild(BinaryNode root) {
        if (null == root) {
            return true;
        }        
        boolean rs = false;        
        if (null == root.left && null == root.right) {
            rs = true;
        }        
        return rs;
    }
    
    /*  方法二 书中的方法，给符合标准的节点分一下类  */
    
    
}
