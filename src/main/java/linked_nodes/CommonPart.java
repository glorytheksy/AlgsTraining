package linked_nodes;

import java.util.HashMap;
import java.util.Map;

import utils.Node;

/**
 * 
 * @ClassName CommonPart
 * @Description 求两个链表的公共部分
 * @author yxmfi
 * @Date 2017年8月30日 下午10:00:49
 * @version 1.0.0
 */
public class CommonPart {
    
    /**
     * 
     * @Description 时间复杂度 O()
     * @param head1
     * @param head2
     */
    public void solution(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            throw new RuntimeException();
        }
        
        Node p1 = head1;
        Node p2 = head2;
        
        Map<Node, Node> map1 = new HashMap<Node, Node>();
        Map<Node, Node> map2 = new HashMap<Node, Node>();
        
        while (!map1.containsKey(p2) && !map2.containsKey(p1) && !(null == p1 && null == p2)) { 
            map1.put(p1, p1);
            map2.put(p2, p2);
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        if (map1.containsKey(p2)) {
            while (null != p2) {
                System.out.println(p2.getValue());
                p2 = p2.getNext();
            }
        } else if (map2.containsKey(p1)) {
            while (null != p1) {
                System.out.println(p1.getValue());
                p1 = p1.getNext();
            }
        }
        
    }
}
