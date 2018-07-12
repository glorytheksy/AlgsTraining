package jianzhiOffer;

import utils.Node;
/**
 * 
 * @ClassName Problem13
 * @Description 
 * @author pc
 * @Date 2018年7月12日 下午5:37:25
 * @version 1.0.0
 */
public class Problem13 {
    
    public static void deleteNode(Node head, Node node) {
        if (null == head || null == node) {
            return;
        }
        
        Node pt_1 = head;
        Node pt_2 = head;
        
        while (pt_2 != node && null != pt_2.getNext()) {
            pt_1 = pt_2;
            pt_2 = pt_2.getNext();
        }
        
        if (pt_2 != node) {
            System.out.println("未找到");
            return;
        }
        
        if (null != pt_2.getNext()) {
            pt_1.setNext(pt_2.getNext());
        } else {
            pt_1.setNext(null);
        }        
        
    }
    
    
}
