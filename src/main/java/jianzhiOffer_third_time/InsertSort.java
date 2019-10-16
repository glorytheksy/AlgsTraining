package jianzhiOffer_third_time;

import jianzhiOffer_first_time.SortUtils;

/**
 * @ClassName InsertSort
 * @Description 
 * @author yxmfi
 * @Date 2019年9月12日 下午5:37:09
 * @version 1.0.0
 */
public class InsertSort {
    
    public void solution(int [] arr) {
        
        if (null == arr) {
            throw new RuntimeException("error");
        }
        if (1 == arr.length) {
            return;
        }
        
        int pt = 1;
        while (pt < arr.length) {
            for (int i=0; i<=pt-1; i++) {
                if (arr[i] > arr[pt]) {
                    SortUtils.exch(arr, pt, i);
                } else {
                    ;
                }                
            }
            pt++;
        }
    }
    
    public static void main(String[] args) {
        InsertSort quick = new InsertSort();
        int [] arr = new int [] {5,1,6,2,35,23};
        quick.solution(arr);
        System.out.println();
        for (int ele : arr) {
            System.out.println(ele);
        }
        
        
    }
    
}
