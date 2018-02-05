package introduction_to_algs;

/**
 * 
 * @ClassName QuickSort
 * @Description 快速排序
 * @author 叶晓蒙
 * @Date 2018年2月5日 下午5:30:11
 * @version 1.0.0
 */
public class QuickSort {
    

    /**
     * divide: partition
     * conquer: 递归
     * combine: 不需要combine
     */    
    public void quickSort(int [] a) {        
        quickSort(a, 0, a.length - 1);                
    }
        
    private void quickSort(int [] a, int start, int end) {
        if (start == end) {
            return;
        }        
        int i = partition(a, start, end);
        if (i - 1 > start) {
            quickSort(a, start, i - 1);
        }
        if (end > i + 1) {
            quickSort(a, i + 1, end);
        }
    }
    
    /**
     * 
     * @Description 以第一个元素为pivot来partition
     * @param arr
     * @param start
     * @param end
     */
    private int partition(int [] arr, int start, int end) {
        int i = start;
        int j = i + 1;
        int pivot = start;
        int x = arr[pivot];
        
        while (j <= end) {
            if (arr[j] < x) {
                i = i + 1;
                exch(arr, i, j);
            }
            j++;
        }
        exch(arr, pivot, i);
        return i;
    }
    
    /**
     * 
     * @Description 随机元素为pivot来partition
     * @param arr
     * @param start
     * @param end
     */
    public int randomPartition(int [] arr, int start, int end) {
        int realPivot = start + (int)Math.floor(Math.random() * (end - start + 1)) ;
        exch(arr, start, realPivot);

        int i = start;
        int j = i + 1;
        int pivot = start;
        int x = arr[pivot];
        
        while (j <= end) {
            if (arr[j] < x) {
                i = i + 1;
                exch(arr, i, j);
            }
            j++;
        }
        exch(arr, pivot, i);
        return i;
        
    }
    
    /**
     * 
     * @Description 交换两个位置的元素值
     * @param arr
     * @param i
     * @param j
     */
    private void exch(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();        
        int arr[] = new int [] {7,1,4,5,10,6};
        ;
        System.out.println(qs.randomPartition(arr, 0, 5));
        System.out.println();
        for (int e :arr) {
            System.out.println(e);
        }
        
    }
    
}
