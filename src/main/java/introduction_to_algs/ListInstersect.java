package introduction_to_algs;

import data_structure.Node;

/**
 * 
 * @ClassName ListInstersect
 * @Description 比较传统的方法求链表的交集(双指针法)
 * @author 叶晓蒙
 * @Date 2018年1月15日 上午9:47:16
 * @version 1.0.0
 */
public class ListInstersect {
    
    /**
     * 
     * @Description 时间复杂度O(l1 + l2)
     * @param l1
     * @param l2
     * @return
     */
    public Node solution1(Node l1, Node l2) {
        Node res = new Node();
        Node p = res;
        
        while(null != l1 && null != l2) {
            
            if (l1.getValue() == l2.getValue()) {
                p.setNext(new Node(l1.getValue()));
                p = p.getNext();
            } else if (l1.getValue() < l2.getValue()) {
                l1 = l1.getNext();
            } else {
                l2 = l2.getNext();
            }            
        }
        
        return res.getNext();
    }
    
    /**
     * 另外有更快的跳表算法，可以省去大量无用的对比
     * 有时间可以实现一下
     */

}
