package zuochengyun_excercises;

import java.util.HashMap;
import java.util.Map;

import data_structure_high_level.RandomNode;

/**
 * 
 * @ClassName RandomPointer
 * @Description 复制含有随机指针的链表
 * @author 叶晓蒙
 * @Date 2017年9月7日 上午8:36:22
 * @version 1.0.0
 */
public class RandomPointer {

    
    /**
     * 
     * @Description 哈希表解法
     * @param head
     * @return
     */
    public RandomNode solution(RandomNode head) {
        
        if (null == head) {
            throw new RuntimeException();
        }
               
        RandomNode old_pt = head;
        RandomNode new_head = new RandomNode(head.value); 
        RandomNode new_pt = new_head;
        
        Map<RandomNode,RandomNode> map = new HashMap<RandomNode,RandomNode>();
        map.put(null, null);
        map.put(old_pt, new_pt);
        while (null != old_pt.next) {
            new_pt.next = new RandomNode(old_pt.next.value);
            new_pt = new_pt.next;
            old_pt = old_pt.next;
            map.put(old_pt, new_pt);
        }
        
        old_pt = head;
        new_pt = new_head;
        while(null != old_pt) {            
            new_pt.rand = map.get(old_pt.rand);
            new_pt = new_pt.next;
            old_pt = old_pt.next;            
        }
        
        return null;
    }
    
    
    /**
     * 
     * @Description 链表组合解法
     * @param head
     * @return
     */
    public RandomNode solution2(RandomNode head) {
        if (null == head) {
            throw new RuntimeException();
        }
        
        RandomNode cur = head;
        RandomNode curNext = cur.next;
        
        while (null != cur) {
            
            RandomNode mid = new RandomNode(cur.value);
            cur.next = mid;
            mid.next = curNext;
            
            cur = curNext;
            if (null != cur)
                curNext = cur.next;
        }
        
        this.randCopy(head);
        return this.seperateCopy(head);
        
    }
    
    /**
     * 
     * @Description 复制rand
     * @param head
     */
    private void randCopy(RandomNode head) {
        if (null == head) {
            throw new RuntimeException();
        }
        
        RandomNode pt = head;        
        while (null != pt) {            
            pt.next.rand = pt.rand.next;            
            if (null != pt.next)
                pt = pt.next.next;            
        }        
    }
    
    /**
     * 
     * @Description 从组合的链表中抽出复制的链表
     * @param head
     * @return
     */
    private RandomNode seperateCopy(RandomNode head) {
        if (null == head) {
            throw new RuntimeException();
        }
                
        RandomNode rsHead = head.next;
        RandomNode pt = head;
        while (null != pt) {
            RandomNode copy = pt.next;  
            if (null != copy) {
                pt.next = copy.next;
                if (null != pt.next) {
                    copy.next = pt.next.next;
                    pt = pt.next;
                } else {
                    break;
                }                                    
            } else {
                break;
            }
        }        
        return rsHead;        
    }
    
}
