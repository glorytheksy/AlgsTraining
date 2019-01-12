package zuochengyun_excercises;

import utils.Node;

/**
 * 
 * @ClassName JosephusProblem
 * @Description Josephus问题，这里只是呈现一下过程，并不对结果做数学上的分析
 * @author yxmfi
 * @Date 2017年9月2日 下午6:14:31
 * @version 1.0.0
 */
public class JosephusProblem {
    
    /**
     * 
     * @Description 只需一个遍历指针，遍历到第二个人时，第二个人跳过第三个人指向第四个人。为了
     *              避免自己指向自己，在环的长度为2的情况下就停止，手动求解
     * @param head
     * @return
     */
    public Node solution(Node circularHead) {
        if (null == circularHead) {
            throw new RuntimeException();
        }
        
        Node p1 = circularHead;
        while (p1.getNext().getNext() != p1) {
            
            for (int i = 0; i < 1; i++) {
                p1 = p1.getNext();
            }
            p1.setNext(p1.getNext().getNext());
            p1 = p1.getNext();            
        }
        
        return p1.getNext();
    }

}
