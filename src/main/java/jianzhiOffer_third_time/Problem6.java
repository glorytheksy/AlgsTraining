package jianzhiOffer_third_time;
import data_structure_basic.BinaryNode;
/*
 * 注意
 */
public class Problem6 {
    
    public BinaryNode reConstruct(int [] pre, int [] mid) {
        if (null == pre || null == mid) {
            throw new RuntimeException("null arr");
        }
           return this.reConstruct(pre, 0, pre.length - 1, mid, 0, mid.length - 1);        
    }
    
    private BinaryNode reConstruct(int [] pre, int pre_start, int pre_end, int [] mid, int mid_start, int mid_end) {
        if (pre_end - pre_start != mid_end - mid_start) {
            throw new RuntimeException("not equal");
        }
        BinaryNode res = new BinaryNode(pre[pre_start]);
        if (pre_start >= pre_end) {
            return res;
        }
        
        int head_pos = this.searchPos(mid, pre[pre_start]);
        int left_len = head_pos - mid_start;
        int right_len = mid_end - head_pos;
        
        /* 这里的长度判断不可或缺，因为有left_len这种特殊情况 */
        if (left_len > 0) {
            res.left = this.reConstruct(pre, pre_start+1, pre_start+left_len, mid, mid_start, mid_start+left_len-1); 
        }
        if (right_len > 0) {
            res.right = this.reConstruct(pre, pre_start+left_len+1 , pre_end, mid, head_pos+1, mid_end);
        }
        
        return res;        
    }
        
    private int searchPos(int [] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Problem6 p = new Problem6();
        int[] pre = new int[] {1,2,4,7,3,5,6,8};
        int [] mid = new int[] {4,7,2,1,5,3,8,6};
        BinaryNode node = p.reConstruct(pre, mid);
//        BinaryNode.preTraverse(node);
        BinaryNode.midTraverse(node);
    }

}
