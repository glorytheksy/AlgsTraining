package zcy_binary_tree;

import java.util.HashMap;
import java.util.Map;

import utils.BinaryNode;

/**
 * 
 * @ClassName LongestValueRoute
 * @Description 在二叉树中找到累加和为指定值的最长路径长度 
 * @author 叶晓蒙
 * @Date 2017年12月21日 下午3:10:45
 * @version 1.0.0
 */
public class LongestValueRoute {
        
    private Map<Integer, Integer> sumMap;
        
    private int maxLen;
    
    private int given;
    
    public LongestValueRoute(BinaryNode head, int given) {
        this.sumMap = new HashMap<Integer, Integer>();
        this.maxLen = -1;
        this.given = given;
        this.getMaxLen(head, sumMap, 0, 0);
    }
    
    public int getMaxLen() {
        return this.maxLen;
    }
    
    
    private void getMaxLen(BinaryNode head, Map<Integer, Integer> sumMap, int preSum, int curLevel) {
        if (null == head) {
            return;
        }
        
        BinaryNode cur = head;        
        Integer headLevel = sumMap.get(cur.value + preSum);                               
        if ( null == headLevel ) {
            sumMap.put(cur.value + preSum, curLevel);
        }                
        if(null != sumMap.get(cur.value + preSum - this.given)) {
            maxLen = max(curLevel - sumMap.get(cur.value + preSum - this.given), maxLen);
        }

        getMaxLen(head.left, sumMap, preSum + cur.value, curLevel + 1);
        getMaxLen(head.right, sumMap, preSum + cur.value, curLevel + 1);
        
        if (null == headLevel) {
            sumMap.remove(cur.value);
        }        
    }
    
    private int max(int a, int b) {
        return a>b?a:b;
    }
    

}
