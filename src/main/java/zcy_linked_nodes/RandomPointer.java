package zcy_linked_nodes;

import java.util.HashMap;
import java.util.Map;

import utils.RanNode;

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
    public RanNode solution(RanNode head) {
        
        if (null == head) {
            throw new RuntimeException();
        }
               
        RanNode old_pt = head;
        RanNode new_head = new RanNode(head.value); 
        RanNode new_pt = new_head;
        
        Map<RanNode,RanNode> map = new HashMap<RanNode,RanNode>();
        map.put(null, null);
        map.put(old_pt, new_pt);
        while (null != old_pt.next) {
            new_pt.next = new RanNode(old_pt.next.value);
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
    public RanNode solution2(RanNode head) {
        if (null == head) {
            throw new RuntimeException();
        }
        
        RanNode cur = head;
        RanNode curNext = cur.next;
        
        while (null != cur) {
            
            RanNode mid = new RanNode(cur.value);
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
    private void randCopy(RanNode head) {
        if (null == head) {
            throw new RuntimeException();
        }
        
        RanNode pt = head;        
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
    private RanNode seperateCopy(RanNode head) {
        if (null == head) {
            throw new RuntimeException();
        }
                
        RanNode rsHead = head.next;
        RanNode pt = head;
        while (null != pt) {
            RanNode copy = pt.next;  
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
