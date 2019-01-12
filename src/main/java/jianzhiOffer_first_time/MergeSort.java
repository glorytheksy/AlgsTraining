package jianzhiOffer_first_time;

/**
 * @ClassName MergeSort
 * @Description 归并排序
 * @author 叶晓蒙
 * @Date 2018年3月9日 上午9:20:11
 * @version 1.0.0
 */
public class MergeSort {
    
    public void mergeSort(int [] arr) {
        int [] tempArr = new int [arr.length]; 
        mergeSort(arr, tempArr, 0, arr.length - 1); 
        for (int e : tempArr) {
            System.out.println(e);
        }
    }
    
    public void mergeSort(int [] arr, int [] tempArr, int lt, int rt) {
        if (lt == rt) {
            return;
        }
        int mid = (lt + rt) / 2;
        mergeSort(arr, tempArr, lt, mid);
        mergeSort(arr, tempArr, mid + 1, rt);
        SortUtils.merge(arr, tempArr, lt, mid, rt);        
    }
    
    
    public static void main(String[] args) {
        int [] arr = new int [] {1,3,5,7,9,2,4,6,8,10};
        MergeSort sort = new MergeSort();
        sort.mergeSort(arr);
    }
    
    
}
