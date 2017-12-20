package data_structure_of_redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @ClassName SkipList
 * @Description 跳跃表的实现（impl of skip list）
 *              这里有个小技巧，跳表的最小和最大值可以设为元素有可能的最小最大值
 *              因为这样有一个好处，是可以不用在跳表的左右两边加元素，只要在跳表
 *              中间加元素就可以了。这样就可以少考虑两种情况！
 *              
 *              另外一个trick是，可以定死跳表的阶数，免得总要添加阶数，很麻烦!
 *              
 * @author yxmfight
 * @Date 2017年9月27日 上午9:11:47
 * @version 1.0.0
 */
public class JumpList<T extends Comparable<T>> {
    
    private List<Node<T>> list;
    
    private Random random;
    
    public JumpList() {
        this.list = new ArrayList<Node<T>>();
        random = new Random();
    }
    
    /**
     * 
     * @Description 跳表的查找, 从跳表最左端开始右向查找node的上界，
     *              找到之后，不断缩小上界;
     *              迭代到最后一行，进行遍历查找
     * @param node
     * @return
     */
    @SuppressWarnings("unchecked")
    public Node<T> get(Node<T> node) {
        if (list.isEmpty()) {
            return null;
        }
         
        Node<T> cur = list.get(list.size() - 1);
        Node<T> upLimit = null;
        for (int i = 0; i < list.size() - 1; i++ ) {
            if (null == cur || null == cur.next) {
                return null;
            }
                        
            if (cur.next.content.compareTo(node.next.content) < 0) {
                upLimit = null;
                cur = cur.next.under;
            } else {
                upLimit = cur.next.under;
                cur = cur.under;                
            }            
        }
               
        while (upLimit != cur) {
            if (cur == node) {
                return node;
            } else {
                cur = cur.next;
            }
        }
        if (cur == node) {
            return node;
        } else {
            return null;
        }        
    }
    
    /**
     *         
     * @Description 跳表的元素插入(默认跳表不包含该元素)
     *              另外，跳表list默认低阶在下
     * @param t
     */
    public void insert(T t) {
        if (list.isEmpty()) {
            list.add(new Node<T>(t));
            return;
        }
        /* 最高阶上方添加一阶  */
        if (list.size() == this.getInsertLevel()) {
            
            list.get(index)
            
            list.add(new Node<T>(t));
            return;
        }
        
        
    }
    
    /**
     * 
     * @Description 获取应插入元素的其实阶
     * @return
     */
    private int getInsertLevel() {
        if (list.isEmpty()) {
            return 0;
        }
        
        int level = list.size();
        for (; level > 0; level--) {
            if (1 == this.insertProb(level)) {
                break;
            }
        }
        return level;
    }
    
    private int insertProb(int level) {
        for (int i = 0; i < level; i++) {
            if (0 == this.halfProbability()) {
                return 0;
            }
        }
        return 1;
    }
    
    private int halfProbability() {
        if (Math.random() > 0.5) {
            return 1;
        } else {
            return 0;
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
                
        public Node(T t) {
            this.content = t;
        }
        
        @Override
        public String toString() {
            return content.toString();
        }
    }

}

