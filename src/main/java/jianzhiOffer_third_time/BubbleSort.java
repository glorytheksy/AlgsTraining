package jianzhiOffer_third_time;

import jianzhiOffer_first_time.SortUtils;

/**
 * 
 * @ClassName BubbleSort
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author yxmfi
 * @Date 2019年9月12日 下午5:19:39
 * @version 1.0.0
 */
public class BubbleSort {
    
    public void solution(int [] arr) {
        
        if (null == arr) {
            throw new RuntimeException("error");
        }
        if (1 == arr.length) {
            return;
        }
        
        for (int i = arr.length - 1; i >= 1; i--) {
            
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1])
                SortUtils.exch(arr, j, j + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        BubbleSort quick = new BubbleSort();
        int [] arr = new int [] {5,1,6,2,35,23};
        quick.solution(arr);
        System.out.println();
        for (int ele : arr) {
            System.out.println(ele);
        }
    }
     

}
