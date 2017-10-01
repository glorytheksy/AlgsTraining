package linked_nodes;

import edu.princeton.cs.algs4.Queue;
import utils.BinaryNode;
import utils.DEndNode;

/**
 * 
 * @ClassName TreeIntoDoubleNodes
 * @Description 二叉树转为双端链表( a Binary tree transformed into a double end node )
 * @author yxmfight
 * @Date 2017年9月27日 下午9:10:19
 * @version 1.0.0
 */
public class TreeIntoDoubleNodes {

    /**
     * 
     * @Description 该题的解法在于以左中右的顺序遍历该树, 
     *              并链接左子结果的尾节点 和  本节点 以及 右子结果的头节点
     *              (link the left result tail to the middle point and the right result head)
     * @param tree
     * @return
     */
    public DEndNode solution(BinaryNode tree) {        
        if (null == tree) {
            return null;
        }
        
        DEndNode leftHead = solution(tree.left);
        DEndNode leftTail = getTail(leftHead);
        
        DEndNode mid = new DEndNode(tree.getValue());
        mid.setPre(leftTail);
        if (null != leftTail)
            leftTail.setPost(mid);
        
        DEndNode rightHead = solution(tree.right);
        mid.setPost(rightHead);
        if (null != rightHead)
            rightHead.setPre(mid);
        
        if (null != leftHead)
            return leftHead;
        else 
            return mid;
    }
    
    /**
     * 
     * @Description 方法2， 首先利用双端队列将树的内容按顺序存起来而不做链接操作，
     *              待所有结果都存在队列里，在在队列内部尽心链接操作。先利用Queque结构掌握顺序信息，再链接操作
     *              这样就规避了方法1的缺点（左结果再遍历一次）。
     *              
     *              时间限制，这里我们就不实现了
     * @param tree
     * @return
     */
    public Queue<BinaryNode> solution2(BinaryNode tree) {
        return null;
    }

    
    
    /**
     * 
     * @Description 解决左结果需要返回尾节点的问题
     * @param head
     * @return
     */
    private DEndNode getTail(DEndNode head) {
        
        if (null == head) {
            return null;
        }
        
        DEndNode pt = head;
        while (null != pt.getPost()) {
            pt = pt.getPost();
        }
        return pt;
    }
    
    
}
