package jianzhiOffer;

import commonly_used_intervew_problems.sorting.SortUtils;

/**
 * @ClassName BubbleSort
 * @Description 
 * @author pc
 * @Date 2018年7月12日 上午11:38:41
 * @version 1.0.0
 */
public class BubbleSort {
    
    public static void solution(int [] a) {
        if (null == a) {
            throw new RuntimeException("input is null");
        }
        if (a.length <= 1) {
            return;
        }
        
        for (int i = 0; i < a.length - 1; i++) {            
            for (int j = 0; j < a.length - i - 1; j++) {                
                if (a[j] > a[j + 1]) {
                    SortUtils.exch(a, j, j + 1);
                } 
            }          
        }        
    }
    
    public static void main(String[] args) {
        int a[] = {5,1,6,2,35,23,1,23,4,3};
//      int a[] = {5,1,6};
      solution(a);
      for (int e : a) {
          System.out.println(e);
      } 
    }
    
}
