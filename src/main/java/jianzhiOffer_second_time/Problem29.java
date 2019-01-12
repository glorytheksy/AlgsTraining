package jianzhiOffer_second_time;

import jianzhiOffer_first_time.SortUtils;

/**
 * @ClassName Problem29
 * @Description 数组中出现次数超过一半的数字
 * @author yxmfight
 * @Date 2018年7月18日 上午8:35:41
 * @version 1.0.0
 */
public class Problem29 {

    /**
     * 最直观的算法，先排序，再去找
     */    
    
    /**
     * 找出排名第k的元素
     */
    public static int findNoKElement(int [] a, int lt, int rt, int k) {      
        int midPos = partition(a, lt, rt);
        if (lt + k - 1 == midPos) {
            return a[lt + k - 1];
        } else if (lt + k - 1 < midPos) {
            return findNoKElement(a, lt, midPos - 1, k);
        } else {
            return findNoKElement(a, midPos + 1, rt, k - (midPos - lt));
        }
    }    
           
    private static int partition(int [] a, int lt, int rt) {
        if (lt == rt) {
            return lt;
        }
        int p1 = lt;
        int p2 = lt + 1;        
        
        while(p2 <= rt) {
            if (a[p2] <= a[lt]) {
                SortUtils.exch(a, p1 + 1, p2);
                p1++;
                p2++;
            } else {
                p2++;
            }
        }        
        SortUtils.exch(a, lt, p1);
        return p1;
    }
    
    
    public static void main(String[] args) {
        int a[] = new int [] {1,2,3,2,2,2,5,4,2};        
        System.out.println(findNoKElement(a, 0, 8, 3));                
    }
    

}
