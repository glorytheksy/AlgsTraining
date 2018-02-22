package introduction_to_algs;

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
    
    private void merge(int [] arr, int [] temp, int left, int right, int split) {                            
        int i = left;
        int j = split;
        int k = left;
        while (i < split || j < right + 1) {
            if (split == i) {
                temp[k] = arr[j++];
            } else if (right + 1 == j) {
                temp[k] = arr[i++];
            } else {
                if (arr[i] > arr[j]) {
                    temp[k] = arr[j++];
                } else {
                    temp[k] = arr[i++];
                }
            }
            k++;
        }
        
        
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
    
    
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();        
        int arr[] = new int [] {5,3,2,1,4};
        int [] rs = ms.mergeSort(arr);
        for (int e : rs) {
            System.out.println(e);
        }
        
    }
}
