package introduction_to_algs;

/**
 * 
 * @ClassName KthSmallest
 * @Description find the k th smallest element in an array
 * @author yxmfight
 * @Date 2018年2月23日 下午5:50:53
 * @version 1.0.0
 */
public class KthSmallest {
    
    /**
     * 
     * @Description 找出arr内部start与end之间排名第k的元素
     * @param arr
     * @param start
     * @param end
     * @param k
     */
    public int solution(int [] arr, int start, int end, int k) {
        
        int pos = this.randomPartition(arr, start, end);
        if (start + k - 1 == pos) {
            return arr[pos];
        } else if (start + k - 1 < pos) {
            return solution(arr, start, pos, k);
        } else {
            return solution(arr, pos, end, k - pos + 1);
        }
        
    }
    
    /**
     * @Description 以第一个元素为pivot来partition
     * @param arr
     * @param start
     * @param end
     */
    private int partition(int [] arr, int start, int end) {
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
    private int randomPartition(int [] arr, int start, int end) {
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
    
    public static void main(String[] args) {
        KthSmallest test = new KthSmallest();
        
        int [] arr = new int [] {7,6,5,4,3,2,1};
        System.out.println(test.solution(arr, 0, 6, 3));
        
    }
}
