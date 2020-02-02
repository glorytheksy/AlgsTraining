package utils;

/**
 * 
 * @ClassName CommonUtils
 * @Description 常用方法以及静态变量
 * @author 叶晓蒙
 * @Date 2018年1月4日 下午6:10:52
 * @version 1.0.0
 */
public class CommonUtils {
    
    public static int max(int a, int b) {
        return a>b?a:b;
    }
    
    public static int min(int a, int b) {
        return a<b?a:b;
    }
    
    public static int mod(int x, int y) {
                
        double quotient = new Double(x).doubleValue() / new Double(y).doubleValue(); 
        return x - y * new Double(Math.floor(quotient)).intValue();
    }
    
    public static void swap(int [] arr, int p1, int p2) {
        if (arr.length - 1 < p1 || arr.length - 1 < p2) {
            throw new RuntimeException("err");
        }
        
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
    
    public static void printArr(int [] arr) {
        if (null == arr) {
            System.out.println("null");
            return;
        }
        
        for (int ele : arr) {
            System.out.print("" + ele + " ");
        }
    }
    
    public static void printArr(int [] arr, int head, int tail) {
        if (null == arr) {
            System.out.println("null");
            return;
        }
        
        for (int i = head; i <= tail; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}
