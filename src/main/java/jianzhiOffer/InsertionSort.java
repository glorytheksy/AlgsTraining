package jianzhiOffer;

import commonly_used_intervew_problems.sorting.SortUtils;

/**
 * @ClassName InsertionSort
 * @Description 插入排序
 * @author pc
 * @Date 2018年7月12日 上午9:04:22
 * @version 1.0.0
 */
public class InsertionSort {

    public static void solution(int a[]) {  
        if (null == a) {
            throw new RuntimeException("input is null");
        }
        for (int i = 0; i < a.length; i++) {
            int temp_pt = i;
            while(temp_pt >= 1 && a[temp_pt] < a[temp_pt - 1]) {
                SortUtils.exch(a, temp_pt, temp_pt - 1);
                temp_pt--;
            }
        }
    }
    
    public static void main(String[] args) {
//        int a[] = {3,4,546,54,654,4,4,4,5,54,8};
//        int a[] = {3,4,546,54,654,4,4,4,5,54,8};
//        int a[] = {3,4,546,54,654,4,4,4,5,54,8};
        int a[] = {};
        solution(a);        
        for (int e : a) {
            System.out.println(e);
        }
    }
}
