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
public class JumpList<T> {
    
    private List<Node<T>> list;
    
    public JumpList() {
        this.list = new ArrayList<Node<T>>();
    }
    
    public Node get(Node node) {
        return node;
        
    }
    
    class Node<T> {
        // 内容
        T content;
        // 下一个节点链接
        Node next;
        // 低一阶的对应节点链接
        Node under;
    }

}

