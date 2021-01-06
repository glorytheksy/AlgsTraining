package dynamic_programming;


public class MaximumSubarray {
    
    public int maxSubArray(int[] nums) {
        int len = nums.length;        
        int dp[] = new int [len];
        dp[0] = nums[0];
        
        int maxSum = nums[0];
        for (int i = 1; i < len; i++) {            
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]); 
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int [] nums = new int [] {1, 2, 10};
        System.out.println(solution.maxSubArray(nums));
    }

}
