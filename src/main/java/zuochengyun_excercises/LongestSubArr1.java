package zuochengyun_excercises;

/**
 * 
 * @ClassName LongestSubArr1
 * @Description 未排序正数数组中累加和为给定值的最长字数组长度
 *              (假设一定存在这样的数组)
 * @author 叶晓蒙
 * @Date 2017年12月15日 下午12:44:58
 * @version 1.0.0
 */
public class LongestSubArr1 {
    
    /**
     * 
     * @Description 虽然说能想到这样的方法比较tricky，但是理解这个算法还是不困难的
     *              我们给所有和加起来是given的数组分下类，以arr[0]开头的, 以arr[1]开头的 ... 以arr[n]开头的
     *              稍微分析一下就可以发现，我们的遍历方法可以遍历所有这些组合
     * @param arr
     * @param given
     * @return 复杂度 O(N)
     */
    public static int solution(int arr[], int given) {     
        
        int pre = 0; // 前指针index
        int post = 0; // 后指针index
        int length = 0; // 和等于given的最长子数组长度
        int sum = arr[0]; // pre到post数组和
        
        while (arr.length - 1 != post) {            
            if (given > sum) {
                post++;
                sum += arr[post];
            } else if (given < sum) {
                sum -= arr[pre];
                pre++;
            } else {
                if ((post - pre + 1) > length) {
                    length = (post - pre + 1);
                }
                pre++;
                sum -= arr[pre];
            }
        }
        
        return length;        
    }
    
    public static void main(String[] args) {
        
        int arr[] = new int[] {1,2,1,1,1};        
        System.out.println(solution(arr, 3));
        
    }

    
}
