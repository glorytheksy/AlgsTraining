package linked_nodes;

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
