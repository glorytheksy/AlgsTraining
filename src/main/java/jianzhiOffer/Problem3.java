package jianzhiOffer;

/**
 * @ClassName Problem3
 * @Description 
 * @author pc
 * @Date 2018年7月11日 上午9:33:15
 * @version 1.0.0
 */
public class Problem3 {
    
   @SuppressWarnings("unused")
   public static Integer solution(int [][] arr, int num) {
       if (null == arr) {
           throw new RuntimeException("null input! arr is null!");
       }
       /* 二维矩阵大小计算 */
       int row_len = arr.length;
       int col_len = arr[0].length;
       return sub_search(arr, 0, col_len - 1, num);       
   }
   
   private static Integer sub_search(int [][] arr, int row, int col, int num) {
       if (num == arr[row][col]) {
           System.out.println("find it");
           return num;
       }
       
       if (num < arr[row][col] && 0 != col) {
           return  sub_search(arr, row, col - 1, num);
       }
       
       if (num > arr[row][col] && arr.length - 1 != row) {
           return sub_search(arr, row + 1, col, num);
       }
       
       /* 找不到的情况统一简单处理 */
       System.out.println("cannot find it");
       return null;
   }
   
   
   
   public static void main(String[] args) {
       int [][] arr = new int [][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15},{1,1,1,1}};              
       System.out.println(solution(arr, 25));       
   }
   
   
}
