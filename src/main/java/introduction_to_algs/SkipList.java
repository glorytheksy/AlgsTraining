package introduction_to_algs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName SkipList
 * @Description 跳表实现，根据算法导论(听了视频，感觉比啃sedgewick的书明了多了，sedgewick的书太啰嗦)
 * @author 叶晓蒙
 * @Date 2018年1月2日 下午12:19:27
 * @version 1.0.0
 */
public class SkipList {

    private List<triDirectNode<Integer>> levelList;        
    public SkipList() {
        levelList = new ArrayList<triDirectNode<Integer>>();
        levelList.add(this.getEmptyLevel());
    }
    
    public Integer get(Integer element) {
        triDirectNode<Integer> res = this.getNode(element);
        if (null == res) {
            return null;
        } else {
            return res.getElement();
        }        
    }

        
    public void insert(Integer element) {
        if (null != this.getNode(element)) {
            System.out.println("已经有该元素");
            return;
        }
        
        int level = 0;
        while (level < this.levelList.size()) {
            if (this.isInsert()) {
                level++;
            } else {
                break;
            }
        }
        
        if (level == this.levelList.size()) {
            this.levelList.add(this.getEmptyLevel());
            levelList.get(level).down = levelList.get(level - 1);
            levelList.get(level).next.down = levelList.get(level - 1).getTail();
        }
        

        triDirectNode<Integer> root = levelList.get(level);
        
        triDirectNode<Integer> upper = new triDirectNode<Integer>(null,null,null,null);        
        triDirectNode<Integer> temp = null;
        
        while(null != root.down) {
            if (element.intValue() < root.next.getElement().intValue()) {
                temp = this.setBetweenAndGet(element, root, root.next);
                upper.down = temp;
                upper = temp;
                root = root.down;
            } else {
                root = root.next;
            }
        }
        
        while (null != root.next) {
            if (element.intValue() < root.next.getElement().intValue()) {                
                temp = this.setBetweenAndGet(element, root, root.next);
                upper.down = temp;
                return;
            }
            root = root.next;
        }    
    }
    
    /**
     * 
     * @Description 首先说明，要删的元素不是收尾元素
     * @param element
     */
    public void delete(Integer element) {
        
        triDirectNode<Integer> node = this.getNode(element);
        while (null != node) {            
            node.prev.next = node.next;
            node.next.prev = node.prev;            
            node = node.down;
        }
        
    }

    
    public int getLevel() {
        return this.levelList.size();
    }
    
    public triDirectNode<Integer> getZero() {
        return this.levelList.get(0);
    }
    
    
    /**
     * @Description 不断缩小范围至跳表底层，再遍历查找
     */
    private triDirectNode<Integer> getNode(Integer element) {
        int level = this.levelList.size() - 1;        
        triDirectNode<Integer> start = levelList.get(level);
        triDirectNode<Integer> limit = levelList.get(level).getTail();
        
        while(null != start.down) {
            if (element.intValue() < start.next.getElement().intValue()) {
                limit = start.next.down;
                start = start.down;                
            } else {
                start = start.next;
                if (element.intValue() == start.getElement().intValue()) {
                    return start;
                }
            }
        }
        
        while (start != limit.next) {
            if (element.intValue() == start.getElement().intValue()) {
                return start;
            }
            start = start.next;
        }        
        return null;
    }
    
    /**
     * @Description 创建头尾各为负正无穷的三向链表
     */
    private triDirectNode<Integer> getEmptyLevel() {        
        triDirectNode<Integer> head = new triDirectNode<Integer>(null, null, null, Integer.MIN_VALUE);
        triDirectNode<Integer> tail = new triDirectNode<Integer>(null, null, null, Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        return head;
    }
    
    /**
     * @Description 是否插入（1/2概率）
     */
    private boolean isInsert() {
        if (Math.random() > 0.5) {
            return true;
        } else {
            return false;
        }
    }
    
    private triDirectNode<Integer> setBetweenAndGet(Integer e, triDirectNode<Integer> left, triDirectNode<Integer> right) {        
        triDirectNode<Integer> mid = new triDirectNode<Integer>(left, null, right, e);
        left.next = mid;
        right.prev = mid;
        return mid;
    }
        
    public static void main(String[] args) {
        
        SkipList list = new SkipList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);
        list.insert(11);

        System.out.println("level: " + list.getLevel());
        
        System.out.println("1: " + list.getNode(1));
        System.out.println("2: " + list.getNode(2));
        System.out.println("3: " + list.getNode(3));
        System.out.println("4: " + list.getNode(4));
        System.out.println("5: " + list.getNode(5));
        System.out.println("6: " + list.getNode(6));
        System.out.println("7: " + list.getNode(7));
        System.out.println("8: " + list.getNode(8));
        System.out.println("9: " + list.getNode(9));
        System.out.println("10: " + list.getNode(10));
        System.out.println("11: " + list.getNode(11));
        System.out.println("12: " + list.getNode(12));
        
        
        list.delete(6);
        list.delete(10);
        
        triDirectNode<Integer> node = list.getZero();
        while (null != node) {
            System.out.println(node.getElement());
            node = node.next;
        }
    }
}
