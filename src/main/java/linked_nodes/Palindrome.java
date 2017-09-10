package linked_nodes;

import utils.Node;
import utils.Stack;
/**
 * 
 * @ClassName LoopNodes
 * @Description 判断链表是否具有回文结构(从左到右和从右到左是一样的)
 * @author yxmfi
 * @Date 2017年9月4日 上午8:05:46
 * @version 1.0.0
 */
public class Palindrome {
    
    /* 方法1：用堆栈存储所有的节点，之后出栈和原链表依次比较，这种方法比较麻烦 ,这里不编写 */

    /**
     * @Description 方法2(利用会文结构本质上是对称)
     * @param head
     * @return
     */
    public boolean solution(Node head) {
        
        if (null == head) {
            return false;
        }
        if (null != head && null == head.getNext()) {
            return true;
        }
        
        
        Node cur = head;
        Node right = head;
        /* 寻找中间点 */
        while ( null != right.getNext() && null != right.getNext().getNext() ) {
            cur = cur.getNext();
            right = right.getNext().getNext();            
        }
        
        /* 右半部分压入栈 */
        Node middle = cur.getNext();    
        Stack rightS = new Stack();
        while (null != middle) {
            rightS.push(middle.getValue());
            middle = middle.getNext();
        }
        
        /* 左右比较 */
        Node pt = head;
        while (!rightS.isEmpty()) {
            if (pt.getValue() != rightS.pop())
                return false;
            pt = pt.getNext();
        }        
        return true;
        
    }
    
}
