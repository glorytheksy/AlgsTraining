package introduction_to_algs;

/**
 * 
 * @ClassName KthSmallest
 * @Description find the k th smallest element in an array
 * @author yxmfight
 * @Date 2018年2月23日 下午5:50:53
 * @version 1.0.0
 */
public class KthSmallest extends PartitionBase {
    
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
    
    
    public static void main(String[] args) {
        KthSmallest test = new KthSmallest();
        
        int [] arr = new int [] {7,6,5,4,3,2,1};
        System.out.println(test.solution(arr, 0, 6, 3));
        
    }
}
