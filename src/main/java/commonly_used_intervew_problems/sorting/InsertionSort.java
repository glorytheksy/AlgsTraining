package commonly_used_intervew_problems.sorting;

/**
 * @ClassName InsertionSort
 * @Description 插入排序算法
 * @author 叶晓蒙
 * @Date 2018年3月8日 下午1:07:20
 * @version 1.0.0
 */
public class InsertionSort {

    /**
     * for A[i] in A:
     *   insert A[i] into A[0] ~ A[i - 1] 
     *   
     * 时间复杂度: 最差情况 二分之N方、最好情况N
     * 额外空间复杂度：O(1)
     */    
    public void insertSort(int [] arr) {        
        for (int i = 0; i < arr.length; i++) {
            insert(arr, i);
        }        
    }
    
    /**
     * @Description 插入操作
     * @param arr
     * @param pos
     */
    private void insert(int [] arr, int pos) {  
        /* 注意判断边界条件 */
        if (0 == pos) {
            return;
        }
        while (pos - 1 >= 0 && arr[pos] < arr[pos - 1]) {
            SortUtils.exch(arr, pos, pos - 1);
            pos--;
        }
                        
    }
        
    public static void main(String[] args) {
        int [] arr = new int [] {5,4,3,2,1,12,33,-1,0};
        InsertionSort sort = new InsertionSort();
        sort.insertSort(arr);
        for (int e : arr) {
            System.out.println(e);
        }
    }
}
