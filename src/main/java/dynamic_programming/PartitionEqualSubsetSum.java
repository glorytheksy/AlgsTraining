package dynamic_programming;

import java.util.Collections;

/**
 * 分割等和子集
 * @author glorythesky
 *
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
    	if (null == nums) {
    		throw new RuntimeException("error");
    	}
    	
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // dp[i][j] 代表前i个数是否可以凑足j
    	boolean dp[][] = new boolean [nums.length + 1][sum];
    	// 前
    	for (int i = 0; i < dp.length; i++) {
    		dp[i][0] = false;
    	}
    	for (int j = 0; j < dp[0].length; j++) {
    		dp[0][j] = false;
    	}
    	
//    	for (int i = 0; i < )
    	
    	return false;
    }
	
	
	
}
