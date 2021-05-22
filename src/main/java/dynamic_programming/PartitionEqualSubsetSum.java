package dynamic_programming;

import java.util.Collections;

/**
 * 分割等和子集
 * @author glorythesky
 *
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
    	int sum = 0;
    	int len = nums.length;
    	for (int i = 0; i < len; i++) {
    		sum+=nums[i];
    	}
    	if (0 != sum % 2) {
    		return false;
    	}
    	
    	int half = sum/2;
    	// dp[i][v] 代表 前i个数字是否可以凑足v
    	boolean dp[][] = new boolean [len + 1][half + 1];
    	dp[0][0] = true;
    	for (int i = 1; i < len + 1; i++) {
    		dp[i][0] = true;
    	}
    	for (int i = 1; i < half + 1; i++) {
    		dp[0][i] = false;
    	}
    	
    	for (int i = 1; i <= len; i++) {
    		for (int j = 1; j <= half; j++) {
    			if (j - nums[i  - 1] < 0) {
    				dp[i][j] = dp[i-1][j];
    			} else {
    				dp[i][j] = dp[i-1][j-nums[i - 1]] || dp[i-1][j];
    			}
    		}
    	}
    	return dp[len][half];
    }
	
	public static void main(String[] args) {
		PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
		
		int [] nums = new int [] {};
		System.out.println(solution.canPartition(nums));
	}
	
}
