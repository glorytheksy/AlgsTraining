package algorithms.sort;

/**
 * 
 * @ClassName MergeSort
 * @Description 归并排序
 * @author 叶晓蒙
 * @Date 2018年2月5日 下午2:32:58
 * @version 1.0.0
 */
public class MergeSort {
    
    /**
     * divide：对半分
     * conquer：递归分
     * conbine:merge
     * 
     * 算法方面比较简单；
     * 实现方面，为了避免创建不必要的数组增加空间复杂度，我们可以在一开始就创建一个空数组，并将其作为函数的参数
     */
    public int [] mergeSort(int [] a) {        
        if (0 == a.length || 1 == a.length) {
            return a;
        }        
        int [] temp = new int [a.length];
        mergeSort(a, temp, 0, a.length - 1);    
        return temp;
    }
    
    /**
     * 
     * @Description 自底向上(略)
     * @param a
     * @return
     */
    public int [] mergeSortBottomUp(int [] a) {
        return null;
    }
    
    private void mergeSort(int [] a, int [] temp, int left, int right) {       
        if (left >= right) {
            return;
        }        
        mergeSort(a, temp, left, left + (right - left)/2);
        mergeSort(a, temp, left + (right - left)/2 + 1, right);
        merge(a, temp, left, right, left + (right - left)/2 + 1);        

    }
    
    /**
     * 
     * @Description 合并已经排好序的两个序列
     * @param arr
     * @param temp
     * @param left
     * @param right
     * @param split
     */
    private void merge(int [] arr, int [] temp, int left, int right, int split) {
        // 方法1 一步一步调整

        int lt = left;
        int rt = split;
        int pt = left;
        while (lt < split || rt < right + 1) {
            if (split == lt) {
                temp[pt] = arr[rt++];
            } else if (right + 1 == rt) {
                temp[pt] = arr[lt++];
            } else {
                if (arr[lt] > arr[rt]) {
                    temp[pt] = arr[rt++];
                } else {
                    temp[pt] = arr[lt++];
                }
            }
            pt++;
        }        
        for (lt = left; lt <= right; lt++) {
            arr[lt] = temp[lt];
        }
        
        

    }
    
    
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();        
        int arr[] = new int [] {5,2,3,1,4,54356,456,546,74,567,90};
        int [] rs = ms.mergeSort(arr);
        for (int e : rs) {
            System.out.println(e);
        }
        
    }
}
