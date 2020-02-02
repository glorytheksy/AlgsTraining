package jianzhiOffer_third_time;

import utils.CommonUtils;
/*
 * trick : 注意head更新的条件是比较苛刻的，没那么简单
 */
public class Problem31 {
    
    public void solution(int [] arr) {
        if (null == arr) {
            throw new RuntimeException("null error");
        }
        
        int head = -1;
        int tail = -1;
        int cumSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        
        int pt = 0;
                
        while (pt < arr.length) {            
            if (arr[pt] >= maxSum && cumSum <= 0) {
                cumSum = arr[pt];
                maxSum = arr[pt];
                head = pt;
                tail = pt;
                pt++;
                continue;
            }
            
            if (arr[pt] <= 0) {
                cumSum = cumSum + arr[pt];
                pt++;                
            } else {
                if (cumSum + arr[pt] > maxSum) {
                    cumSum = cumSum + arr[pt];
                    maxSum = cumSum;
                    tail = pt;
                    pt++;
                } else {
                    cumSum = cumSum + arr[pt];
                    pt++;   
                }               
            }
        }
        
        System.out.print("Series: ");
        CommonUtils.printArr(arr, head, tail);
        System.out.println("sum: " + maxSum);        
    }
    
    public static void main(String[] args) {
        Problem31 p = new Problem31();
        int [] arr = new int [] {1, -2, 3, 10, -4, 7, 2, -5};
        p.solution(arr);
    }
    

}
