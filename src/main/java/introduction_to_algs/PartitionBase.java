package introduction_to_algs;


public class PartitionBase {
    
    
    /**
     * @Description 以第一个元素为pivot来partition
     * @param arr
     * @param start
     * @param end
     */
    protected int partition(int [] arr, int start, int end) {
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
    protected int randomPartition(int [] arr, int start, int end) {
        int realPivot = start + (int)Math.floor(Math.random() * (end - start + 1)) ;
        exch(arr, start, realPivot);        
        return partition(arr, start, end);        
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

}
