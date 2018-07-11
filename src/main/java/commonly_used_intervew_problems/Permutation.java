package commonly_used_intervew_problems;

/**
 * @ClassName Permutation
 * @Description 全排列算法
 * @author 叶晓蒙
 * @Date 2018年3月30日 上午8:44:45
 * @version 1.0.0
 */
public class Permutation {
    
    /**
     * @Description 
     * @param arr
     */
    public void permutation(int [] arr) {        
        if (null == arr) {
            return;
        }
        if (0 == arr.length) {
            return;
        }
        this.permutation(arr, 0);        
    }
    
    /**
     * 
     * @Description n问题分解为 1 问题 和 (n - 1) 问题, 有点像动态规划，但其实不是（父问题和子问题不是包含关系）
     * @param arr
     * @param pos
     */
    private void permutation(int [] arr, int pos) {
        if (arr.length - 1 == pos) {
            for (int e : arr) {
                System.out.print(e);                
            }
            System.out.println();
            return;
        }
        
        for (int i = pos; i < arr.length; i++) {      
            
            
            permutation(arr, pos + 1);            
            swap(arr, pos, arr.length - 1 - i);
        }                        
    }
    
    private void swap(int [] arr, int pos_a, int pos_b) {
        int temp = arr[pos_a];
        arr[pos_a] = arr[pos_b];
        arr[pos_b] = temp;        
    }
    
    public static void main(String[] args) {
        Permutation alg = new Permutation();
        
        int arr[] = new int [] {1,2,3};
        alg.permutation(arr);
    }

}
