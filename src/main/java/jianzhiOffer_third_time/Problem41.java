package jianzhiOffer_third_time;

import utils.CommonUtils;

/*
 * trick: 双指针移动
 */
public class Problem41 {    
    
    public void solution(int [] arr, int val) {
        if (null == arr) {
            throw new RuntimeException("null error");
        }
        if (1 == arr.length) {
            if (val == arr[0]) {
                System.out.println("0");
            }
        }
        
        int p1 = 0;
        int p2 = 1;
        int cumSum = arr[0] + arr[1];
        
        while (true) {
            
            if (val == cumSum) {
                CommonUtils.printArr(arr, p1, p2);
                if (p2 < arr.length - 1) {
                    p2++;
                    cumSum = cumSum + arr[p2];
                } else {
                    break;
                }
            } else if (val > cumSum && p2 < arr.length - 1) {
                p2++;
                cumSum = cumSum + arr[p2];
            } else if (val > cumSum && arr.length - 1 == p2) {
                break;
            } else if (val < cumSum && p1 <= p2) {
                cumSum = cumSum - arr[p1];
                p1++;                
            } else {
                break;
            }
        }
    }
    
    
    public static void main(String[] args) {
        Problem41 p = new Problem41();
        int [] arr = new int [] {1,2,3,4,5,6,7,8};
        int val = 15;
        
        
        p.solution(arr, val);
    }
    
}
