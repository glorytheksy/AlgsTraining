package introduction_to_algs;

/**
 * 
 * @ClassName CountSort
 * @Description 计数排序
 * @author 叶晓蒙
 * @Date 2018年2月7日 下午5:12:48
 * @version 1.0.0
 */
public class CountSort {
    
    public int [] countSort(int [] a) {        
        // 我们假设元素大小在0 ~ 9之间
        int k = 10;

        int [] c = new int [k];
        int [] b = new int [a.length]; 
        
        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {
            c[a[i]] = c[a[i]] + 1;
        }
        for (int i = 0; i < k; i++) {
            if (0 == i) {
                ;
            } else {
                c[i] = c[i-1] + c[i]; 
            }            
        }
        for (int i = a.length - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]] = c[a[i]] - 1;
        }        
        return b;
    }
    
    public static void main(String[] args) {                
        CountSort cs = new CountSort();        
        int arr[] = new int [] {7,1,1,1,1,1,4,4,4,4,4,5,9,6};        
        int [] a = cs.countSort(arr);
        for (int e :a) {
            System.out.println(e);
        }
        
        
    }
    
}
