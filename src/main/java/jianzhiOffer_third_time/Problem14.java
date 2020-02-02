package jianzhiOffer_third_time;

import utils.CommonUtils;

public class Problem14 {
    
    public void solution (int [] arr) {
        
        if (null == arr) {
            throw new RuntimeException("null arr");
        }
        
        int p1 = 0;
        int p2 = arr.length - 1;
        
        while (p1 < p2) {
            
            if (isOdd(arr[p1]) && isOdd(arr[p2])) {
                p1++;
            } else if (!isOdd(arr[p1]) && !isOdd(arr[p2])) {
                p2--;
            } else if (isOdd(arr[p1]) && !isOdd(arr[p2])) {
                p1++;
                p2--;
            } else {
                CommonUtils.swap(arr, p1, p2);
                p1++;
                p2--;
            }
        }
        
    }
    
    public boolean isOdd(int num) {
        if (0 == num % 2) {
            return false;
        } else {
            return true;
        }
    }
    
    public static void main(String[] args) {
        Problem14 p = new Problem14();
        
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10,11};
        p.solution(arr);
        CommonUtils.printArr(arr);
        
    }

}
