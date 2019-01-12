package jianzhiOffer_second_time;

/**
 * @ClassName Problem24
 * @Description 
 *              输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *              如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互
 *              不相同
 * @author yxmfi
 * @Date 2018年7月17日 上午10:25:12
 * @version 1.0.0
 */
public class Problem24 {
    
    public static boolean solution(int [] a) {
        if (null == a) {
            throw new RuntimeException("input is null");
        }
        return isBackTree(a, 0, a.length - 1);                
    }
    
    private static boolean isBackTree(int [] a, int lt, int rt) {
        if (rt - lt <= 1) {
            return true;
        }
        
        int mid = lt - 1;        
        for (int i = lt; i <= rt; i++) {
            if (a[i] > a[rt]) {
                mid = i - 1;
                for (int j = i + 1; j <= rt; j++) {
                    if (a[j] < a[rt]) {
                        return false;
                    }
                }
            } else {
                mid = i + 1;
            }
        }
        
        if (mid < lt || mid > rt) {
            return isBackTree(a, lt, rt - 1);
        } else {
            return isBackTree(a, lt, mid) && isBackTree(a, lt, mid + 1);
        }                
    }
    
    public static void main(String[] args) {
        int a [] = new int [] {5,7,6,60,7,9,11,10,8}; 
        boolean rs = solution(a);
        System.out.println(rs);
    }
    
}
