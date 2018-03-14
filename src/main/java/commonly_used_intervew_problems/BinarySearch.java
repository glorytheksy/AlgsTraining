package commonly_used_intervew_problems;

/** 
 * @ClassName BinarySearch
 * @Description 二分查找
 * @author 叶晓蒙
 * @Date 2018年3月12日 下午4:19:26
 * @version 1.0.0
 */
public class BinarySearch {
    
    /**
     * @Description 假设arr的元素从小到大排列
     * @param arr
     * @param target
     * @return
     */
    public int binarySearch(int [] arr, int target) {
        if (null == arr) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid = (end + start) / 2;
        while (mid >= start) {
            if (target == arr[mid]) {
                return mid;
            }
            /* mid无法到达数组最后一位 */
            if (target == arr[mid + 1]) {
                return mid + 1;
            }
            
            if (target > arr[mid]) {
                start = mid;
            } else if (target < arr[mid]) {
                end = mid;
            }            
            mid = (end + start) / 2;
        }        
        return -1;
    }
    
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int [] arr = new int [] {11,12,13,14,15,16,17,18,19,20};
        int pos = bs.binarySearch(arr, 20);
        System.out.println(pos);
    }
    
}
