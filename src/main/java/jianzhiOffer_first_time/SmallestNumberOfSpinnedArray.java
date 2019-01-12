package jianzhiOffer_first_time;

/**
 * 
 * @ClassName SmallestNumberOfSpinnedArray
 * @Description 旋转数组的最小数字
 * @author 叶晓蒙
 * @Date 2018年3月12日 下午4:41:36
 * @version 1.0.0
 */
public class SmallestNumberOfSpinnedArray {
    
    public int binarySearch(int [] arr) {
        if (null == arr) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid =  (end + start) / 2;
        
        if (arr[end - 1] > arr[end]) {
            return end;
        }
        
        while (mid >= start) {
            if (isRight(arr, start, mid, end)) {
                return mid;
            }else {
                if (arr[end] > arr[mid]) {
                    end = mid;
                } else if (arr[end] < arr[mid]) {
                    start = mid;
                }            
                mid = (end + start) / 2;
            }
        }        
        return -1;
    }
    
    private boolean isRight(int [] arr, int start, int mid, int end) {
        if (mid == 0) {
            return true;
        }
        if (arr[mid - 1] > arr[mid]) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        SmallestNumberOfSpinnedArray test = new SmallestNumberOfSpinnedArray();
//        int [] arr = new int [] {3,4,5,1,2};
        int [] arr = new int [] {2,3,4,5,1};
//        int [] arr = new int [] {1,2,3,4,5};
        int rs = test.binarySearch(arr); 
        System.out.println(rs);
    }
}
