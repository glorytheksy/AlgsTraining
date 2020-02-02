package jianzhiOffer_third_time;

import utils.CommonUtils;
/*
 * trick: 要想节省空间和时间，从尾到头遍历
 */
public class Problem4 {

    public void solution(int[] arr_long, int pos, int[] arr_short) {
        if (null == arr_long || null == arr_short) {
            throw new RuntimeException("null");
        }

        int p1 = pos;
        int p2 = arr_short.length - 1;

        int pt = arr_long.length - 1;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0 && p2 < 0) {
                arr_long[pt] = arr_long[p1];
                pt--;
                p1--;
                continue;
            }

            if (p2 >= 0 && p1 < 0) {
                arr_long[pt] = arr_short[p2];
                pt--;
                p2--;
                continue;
            }

            if (arr_long[p1] <= arr_short[p2]) {
                arr_long[pt] = arr_short[p2];
                pt--;
                p2--;
            } else {
                arr_long[pt] = arr_long[p1];
                pt--;
                p1--;
            }
        }

    }

    public static void main(String[] args) {
        Problem4 p = new Problem4();
        
        int[] arr_long = new int[] {1,3,5,7,10,0,0,0,0,0,0,0};
        int [] arr_short = new int[] {2,4,8,11,23,44,78};
        p.solution(arr_long, 4, arr_short);
        
        CommonUtils.printArr(arr_long);
    }

}
