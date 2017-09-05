package linked_nodes;

import utils.Node;

/**
 * 
 * @ClassName ReversePartNodes
 * @Description 反转部分单向链表
 * @author yxmfi
 * @Date 2017年9月2日 下午5:55:41
 * @version 1.0.0
 */
public class ReversePartNodes {
    /**
     * 
     * @Description 算法，1. 找到第from个节点
     *                    2. 反转to - from + 1个节点(方法同ReverseNodes)
     *                    3. 注意from往前一个节点 和 to往后一个节点也要改变  
     * 
     * @param head
     * @param from
     * @param to
     */
    public void solution(Node head, int from, int to) {
        if (0 > from || 0 > to || to <= from) {
            throw new RuntimeException();
        }
        
    }
    
}
