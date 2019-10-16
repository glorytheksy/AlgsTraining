package jianzhiOffer_third_time;

import jianzhiOffer_first_time.SortUtils;

/**
 * @ClassName QuickSort
 * @Description 快排
 * @author yxmfi
 * @Date 2019年9月11日 下午12:52:55
 * @version 1.0.0
 */
public class QuickSort {
    
    public void solution(int [] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private void quickSort(int [] arr, int start, int end) {
        if (start == end || start > end) {
            return;
        }
        
        int pos = 0;
        pos = partition(arr, start, end);
        quickSort(arr, start, pos - 1);
        quickSort(arr, pos + 1, end);
    }
    
    public int partition(int [] arr, int start, int end) {
        /** 简单的方法：建立两个数组，分别存放
         *  方法2：前后各设置一个指针，来回交换,要考虑的情况太复杂了
         *  方法3：在第一个位置和第二个位置各设置指针
         */ 
        if (start == end) {
            return start;
        }
        
        int pt1 = start;
        int pt2 = start + 1;
        
        while(pt2 <= end) {            
            if (arr[pt2] < arr[pt1]) {
                pt1++;
                SortUtils.exch(arr, pt1 - 1, pt2);                
            } else {
                pt2++;
            }
        }
        return pt1;
    }
    
    public static void main(String[] args) {
        QuickSort quick = new QuickSort();
        int [] arr = new int [] {5,1,6,2,35,23};
//        System.out.println(quick.partition(arr, 0, arr.length - 1));
        quick.solution(arr);
        System.out.println();
        for (int ele : arr) {
            System.out.println(ele);
        }
    }
    
}
