package leetcode.algs.sliding_window;


/**
 * @author glorythesky
 * problem_209
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead. 
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
    	if (null == nums || 0 == nums.length) {
    		return 0;
    	}    	
    	
    	int lt = 0;
    	int rt = 0;
    	int curMinLen = Integer.MAX_VALUE;
    	int curLen = 1;
    	int curSum = nums[0]; 
    	    	
    	while (nums.length - 1 != rt) {
    		if (curSum >= s) {
    			if (curMinLen > curLen) {
    				curMinLen = curLen; 
    			}
    			if (1 < curLen) {
        			curSum -= nums[lt];
        			lt++;
        			curLen--;   
    			} else {
        			rt++;
        			curLen++;
        			curSum += nums[rt];
    			} 			
    		} else {
    			rt++;
    			curLen++;
    			curSum += nums[rt];
    		}    		   		
    	}
    	
    	while (curSum >= s && rt != nums.length) {   		
    		
			if (curMinLen > curLen) {
				curMinLen = curLen; 
			}
			if (1 < curLen) {
    			curSum -= nums[lt];
    			lt++;
    			curLen--;   
			} else {
    			rt++;
			} 
    	}   	    	 
    	if (Integer.MAX_VALUE == curMinLen) {
    		return 0;
    	} else {
        	return curMinLen;
    	}
    }
    
    
    public static void main(String[] args) {
    	 int s = 7;
    	 int [] nums = new int[] {2,3,1,2,4,3};    	 
//    	 int [] nums = new int[] {2};    	 

    	 MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
    	 System.out.println(solution.minSubArrayLen(s, nums));
    }    
}
