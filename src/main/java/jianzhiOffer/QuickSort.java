package jianzhiOffer;

import commonly_used_intervew_problems.sorting.SortUtils;

/**
 * @ClassName FastSort
 * @Description 
 * @author pc
 * @Date 2018年7月12日 上午10:12:41
 * @version 1.0.0
 */
public class QuickSort {
    
    public static void solution(int a[]) {
        if (null == a) {
            throw new RuntimeException("input is null");
        }
        quickSort(a, 0, a.length - 1);
    }
    
    private static void quickSort(int a[], int lt, int rt) {
        if (lt == rt) {
            return ;
        }
        
        int pivot = partition(a, lt, rt);        
        if (pivot - 1 > lt) {
            quickSort(a, lt, pivot - 1);
        }
        if (rt > lt + 1) {
            quickSort(a, pivot + 1, rt);
        }
    }
    
    public static int random_partition(int [] a, int lt, int rt) {
        int realPivot = lt + (int)Math.floor(Math.random() * (rt - lt + 1)) ;
        SortUtils.exch(a, lt, realPivot);        
        return partition(a, lt, rt);  
    }
    
    public static int partition(int [] a, int lt, int rt) {
        if (lt == rt) {
            return rt;
        }
        
        int p1 = lt;
        int p2 = lt + 1;
        
        /* p2由左向右边扫描 */
        while(p2 <= rt) {
            if (a[p2] < a[lt]) {
                p1++;
                SortUtils.exch(a, p1, p2);
            }
            p2++;
        }        
        SortUtils.exch(a, p1, lt);
        return p1;
    }
    
    public static void main(String[] args) {
        int a[] = {5,1,6,2,35,23,1,23,4,3};
//        int a[] = {5,1,6,2};
        solution(a);
        for (int e : a) {
            System.out.println(e);
        } 
    }
    
}
