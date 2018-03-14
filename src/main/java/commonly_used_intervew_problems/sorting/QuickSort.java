package commonly_used_intervew_problems.sorting;

/**
 * 
 * @ClassName QuickSort
 * @Description 快速排序
 * @author 叶晓蒙
 * @Date 2018年3月12日 上午10:12:50
 * @version 1.0.0
 */
public class QuickSort {
    
    public void quickSort(int [] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private void quickSort(int [] arr, int lt, int rt) {
        if (null == arr) {
            return;
        }
        if (lt == rt) {
            return;
        }
        if (lt < rt) {
            throw new RuntimeException("error");
        }
        
        int pos = this.partition(arr, lt, rt);
        quickSort(arr, lt, pos);
        quickSort(arr, pos + 1, rt);
    }
    
    /**
     * @Description 选择第一个元素作为分隔，从左到右遍历数组段中的元素，如果有比第一个元素小的，就将其移动到左侧
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int partition(int [] arr, int start, int end) {        
        int p1 = start;
        int p2 = start + 1;
        
        while (p2 <= end) {
            if (arr[p2] < arr[start]) {
                SortUtils.exch(arr, p1 + 1, p2);
                p1++;
            }
            p2++;
        }
        
        SortUtils.exch(arr, start, p1);        
        return p1; 
    }
    
    /**
     * 
     * @Description 在从start到end中随机挑选一个参数，与start交换
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int randomPartition(int [] arr, int start, int end) {
        int realPivot = start + (int)Math.floor(Math.random() * (end - start + 1)) ;
        SortUtils.exch(arr, start, realPivot);        
        return partition(arr, start, end);   
    }
        
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        
        int [] arr = new int [] {5,4,3,1,34,67,90};
        qs.quickSort(arr);
        for (int e : arr) {
            System.out.println(e);
        }
    }
       
}
