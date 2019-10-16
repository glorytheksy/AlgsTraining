package jianzhiOffer_third_time;

/**
 * 
 * @ClassName BinarySearch
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author yxmfight
 * @Date 2019年9月9日 下午11:31:11
 * @version 1.0.0
 */
public class BinarySearch {
    
    public static void solution(int [] arr, int val) {
        
        if (null == arr) {
            throw new RuntimeException("error");
        }
        
        int start = 0;
        int end = arr.length - 1;
        int mid = (end + start) / 2;
        
        while (start <= end) {
            
            if (val == arr[mid]) {
                System.out.println("pos is " + mid);
                return;
            } else if (arr[mid] > val) {
                end = mid - 1;
                mid = (end + start) / 2;
                continue;
            } else {
                start = mid + 1;
                mid = (end + start) / 2;
                continue;
            }           
        }        
        System.out.println("val not found");      
    }
        
    public static boolean solution2(int [] arr, int start, int end, int val) {
        if (null == arr || start < 0 || end > arr.length - 1 || start > end) {
            throw new RuntimeException("logic error");
        }
                
        int mid = (start + end) / 2;
        if (val == arr[mid]) {
            System.out.println("pos is " + mid);
            return true;
        } else if (val < arr[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        
        return solution2(arr, start, end, val);
                
    }
            
    public static void main(String[] args) {
        int[] arr = new int [] {1,4,6,12,13,56,90,110,2222,345435};        
        solution2(arr, 0, arr.length - 1, 1);                
    }
        
}
