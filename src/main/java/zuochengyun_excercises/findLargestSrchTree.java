package zuochengyun_excercises;


import utils.BinaryNode;

/**
 * 
 * @ClassName findLargestSrchTree
 * @Description 找到节点最多的搜索树
 * @author yxmfight
 * @Date 2017年12月25日 下午10:28:07
 * @version 1.0.0
 */
public class findLargestSrchTree {

    /**
     * 这道题目要用到全局变量，这是我之前很少遇到过的。
     * 因为在递归函数中由于无法返回多个变量，这在python里应该
     * 相对容易实现
     * 特别注意，全局变量应该在什么时候清零
     */
    
    private int max;    
    private int min;
    private int size;
    
    private int lmax;    
    private int lmin;
    private int lsize;
    
    private int rmax;    
    private int rmin;
    private int rsize;
    
    public BinaryNode solution(BinaryNode head) {
        if (null == head) {
            max = 0 - Integer.MAX_VALUE;
            min = Integer.MAX_VALUE;
            size = 0;
        }
        
        BinaryNode lt = solution(head.left);
        lmax = max;
        lmin = min;
        lsize = size;
        BinaryNode rt = solution(head.right);
        rmax = max;
        rmin = min;
        rsize = size;
        
        if (lt == head.left && lmax < head.value && 
                rt == head.right && rmin > head.value) {
            size = size + lsize + rsize;
            min = (lmin > head.value) ? head.value:lmin;
            max = (rmax < head.value) ? head.value:rmax;
            return head;
        }

        
        min = (lmin > head.value) ? head.value:lmin;
        max = (rmax < head.value) ? head.value:rmax;        
        if (lsize > rsize) {
            size = lsize;
            return lt;
        } else {
            size = rsize;
            return rt;
        }
    }
    
}
