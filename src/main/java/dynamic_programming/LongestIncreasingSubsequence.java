package dynamic_programming;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
    	if (null == nums || 0 == nums.length) {
    		return 0;
    	}
    	
    	// dp[i] 第i个元素为结尾的最长子序列(不要求连续)长度
    	int dp [] = new int [nums.length];
    	
    	dp[0] = 1;
    	int max = 0;
    	int res = 1;
    	for (int i = 1; i < nums.length; i++) {
    		max = 0;
    		for (int j = 0; j < i; j++) {
    			if (nums[j] < nums[i]) {
    				max = Math.max(max, dp[j]);
    			} else {
    				continue;
    			}
    		}
    		
    		if (0 == max) {
    			dp[i] = 1;
    		} else {
    			dp[i] = max + 1;
    		}
    		
    		if (res < dp[i]) {
    			res = dp[i];
    		}
    	}
    	
    	return res;
    }
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		int [] nums = new int [] {0,1,0,3,2,3};
		System.out.println(solution.lengthOfLIS(nums));
	}
}
