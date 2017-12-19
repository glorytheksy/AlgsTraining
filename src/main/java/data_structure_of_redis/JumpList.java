package data_structure_of_redis;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName SkipList
 * @Description 跳跃表的实现（impl of skip list）
 * @author yxmfight
 * @Date 2017年9月27日 上午9:11:47
 * @version 1.0.0
 */
public class JumpList<T extends Comparable<T>> {
    
    private List<Node<T>> list;
    
    public JumpList() {
        this.list = new ArrayList<Node<T>>();
    }
    
    @SuppressWarnings("unchecked")
    public Node get(Node node) {
        if (list.isEmpty()) {
            return null;
        }
         
        Node<T> cur = list.get(list.size() - 1);
        Node<T> upLimit = null;
        for (int i = 0; i < list.size() - 1; i++ ) {
            if (null == cur) {
                return null;
            }
                        
            if (cur.next.content.compareTo(node.next.content) < 0) {
                cur = cur.next.under;
            } else {
                upLimit = cur.next.under;
                cur = cur.under;
                
            }            
        }
        
        
        
    }
    
    @SuppressWarnings("hiding")
    class Node<T extends Comparable<T>> {
        // 内容
        T content;
        // 下一个节点链接
        @SuppressWarnings("rawtypes")
        Node next;
        // 低一阶的对应节点链接
        @SuppressWarnings("rawtypes")
        Node under;
    }

}

