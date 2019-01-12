package zuochengyun_excercises;

import org.apache.log4j.Logger;

import data_structure.Node;

/**
 * 
 * @ClassName ReversePointsOnCertainLenth
 * @Description reverse points with the interval of K steps
 *              单链表每个K节点之间逆序
 * @author yxmfiht
 * @Date 2017年9月23日 上午10:45:21
 * @version 1.0.0
 */
public class ReversePointsOnCertainLenth {
    
    private Logger logger = Logger.getLogger(this.getClass());

    public Node solution(Node head, int K) {
        if (null == head || K <= 1) {
            throw new RuntimeException();
        }
        
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < K - 1; i++) {
            p2 = p2.getNext();
            if (null == p2) {
                logger.warn("K is too big!");
                return head;
            }
        }
        
        while (null != p1 && null != p2) {
            int temp = p1.getValue();
            p1.setValue(p2.getValue());
            p2.setValue(temp);
            
            p1 = p2.getNext(); // p1 doesn't have to move K steps
            p2 = LinkedNodesUtils.moveForward(p2 ,K);
        }
        
        return head;
    }
    
}
