package zuochengyun_excercises;

import java.util.ArrayList;
import java.util.List;

import data_structure.Node;
import data_structure.Queue;
import data_structure.Stack;

/**
 * 
 * @ClassName Seperation
 * @Description 用一个值将链表分为两部分（以对比该值大小区分）
 * @author pc
 * @Date 2017年9月5日 下午12:43:10
 * @version 1.0.0
 */
public class Seperation {
    
    
    /**
     * 
     * @Description 保持有序的情况
     * @param head
     * @param sep
     * @return
     */
    public Node solution1(Node head, int sep) {
        
        Node rs = new Node(0);
                
        if (null == head) {
            throw new RuntimeException();
        }
        
        Queue<Integer> smal = new Queue<Integer>();
        Stack eql = new Stack();
        Queue<Integer> big = new Queue<Integer>();
        
        Node pt = head;
        
        while (null != pt) {
            if (sep > pt.getValue()) 
                smal.add(pt.getValue());
            else if (sep < pt.getValue())
                big.add(pt.getValue());
            else 
                eql.push(pt.getValue());            
            pt = pt.getNext();
        }
        
        pt = rs;
        
        while(!smal.isEmpty()) {
            pt.setNext(new Node(smal.poll()));
            pt = pt.getNext();
        }
        
        while (!eql.isEmpty()) {
            pt.setNext(new Node(eql.pop()));
            pt = pt.getNext();
        }

        while (!big.isEmpty()) {
            pt.setNext(new Node(big.poll()));
            pt = pt.getNext();
        }
        
        return rs.getNext();
    }
    
    /**
     * 
     * @Description 空间复杂度为O(1)的解法 (这个解法虽然复杂度低，但是编起来很麻烦！)
     * @param head
     * @param sep
     * @return
     */
    public Node solution2(Node head, int sep) { 
        
        if (null == head || null == head.getNext()) {
            throw new RuntimeException();
        }
        
        Node smal = new Node(0);
        Node eqal = new Node(0);
        Node big = new Node(0);
        
        Node smalTail = smal;
        Node eqalTail = eqal;
        Node bigTail = big;
                
        Node pt = new Node(0);
        pt.setNext(head);
        while (null != pt && null != pt.getNext()) {
            if (sep > pt.getNext().getValue()) {
                smalTail.setNext(pt.getNext());
                smalTail = pt.getNext();
                delNext(pt);
            }
            else if (sep == pt.getNext().getValue()) {
                eqalTail.setNext(pt.getNext());
                eqalTail = pt.getNext();
                delNext(pt);
            }
            else {
                bigTail.setNext(pt.getNext());
                bigTail = pt.getNext();
                delNext(pt);
            }
        }
        smalTail.setNext(null);
        eqalTail.setNext(null);
        bigTail.setNext(null);
        
        List<HeadAndTail> list = new ArrayList<HeadAndTail>();
        list.add(new HeadAndTail(smal, smalTail));
        list.add(new HeadAndTail(eqal, eqalTail));
        list.add(new HeadAndTail(big, bigTail));
        return reunite(list);
    }
    
    /**
     * 
     * @Description 删除pt下一个节点
     * @param pt
     */
    private void delNext(Node pt) {        
        if (null == pt || null == pt.getNext()) {
            return;
        }        
        pt.setNext(pt.getNext().getNext());        
    }
    
    /**
     * 
     * @Description 合并链表（默认每个链表头尾不为null， 且链表头是冗余信息）
     * @param list
     * @return
     */
    private Node reunite(List<HeadAndTail> list) {
        if (null == list) {
            return null;
        }
        
        Node rs = null;
        Node rsTail = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).head != list.get(i).tail) {
                if (null == rs)
                    rs = list.get(i).head;
                if (i + 1 < list.size()) 
                    list.get(i).tail.setNext(list.get(i + 1).head);
                else 
                    list.get(i).tail.setNext(null);
            }
        }
        return rs;
    }
    
    
    
    class HeadAndTail {
        Node head;
        Node tail;
                
        public HeadAndTail(Node head, Node tail) {
            if (null == head || null == tail) {
                throw new RuntimeException();
            }
            this.head = head;
            this.tail = tail;
        }
    }

}
