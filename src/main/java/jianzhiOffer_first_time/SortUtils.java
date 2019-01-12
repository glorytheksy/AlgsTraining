package jianzhiOffer_first_time;

/**
 * 
 * @ClassName SortUtils
 * @Description 排序常用
 * @author 叶晓蒙
 * @Date 2018年3月8日 下午3:16:29
 * @version 1.0.0
 */
public class SortUtils {

    /**
     * @Description 交换
     * @param arr
     * @param pos_1
     * @param pos_2
     */
    public static void exch(int [] arr, int pos_1, int pos_2) {
        int temp = arr[pos_1];        
        arr[pos_1] = arr[pos_2];
        arr[pos_2] = temp;
    }
    

    /**
     * 
     * @Description merge操作(假设从 lt 到 mid 是一组，从 mid + 1 到 rt 是一组)
     * @param arr
     * @param lt
     * @param mid
     * @param tempArr 临时填装merge后的子数组
     */
    public static void merge(int [] arr, int [] tempArr, int lt, int mid, int rt) {
        if (lt > mid || mid > rt) {
            throw new RuntimeException("error");
        }
        
        int p1 = lt;
        int p2 = mid + 1;
        int count = 0;
        
        while (p1 <= mid || p2 <= rt) {            
            if (p1 > mid) {
                tempArr[lt + count] = arr[p2];
                p2++;
                count++;
            } else if (p2 > rt) {
                tempArr[lt + count] = arr[p1];
                p1++;
                count++;
            } else {                
                if (arr[p1] > arr[p2]) {
                    tempArr[lt + count] = arr[p2];
                    p2++;
                    count++;
                } else {
                    tempArr[lt + count] = arr[p1];
                    p1++;
                    count++;
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        
    }
    
}
