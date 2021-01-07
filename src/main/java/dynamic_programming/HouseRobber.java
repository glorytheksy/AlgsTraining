package dynamic_programming;


public class HouseRobber {
    
    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        
        
        // dp[i]  代表以第i+1个元素结尾的结果
        int [] dp = new int [nums.length]; 
        dp[0] = nums[0];
        
        int MaxPre = 0; // dp[0]~dp[i-2]中最大的值 
        for (int i = 1; i < nums.length; i++) {
            dp[i] = MaxPre + nums[i];
            
            if (dp[i - 1] > MaxPre) {
                MaxPre = dp[i - 1];
            }
        }
        
        if (dp[nums.length - 1] > MaxPre) {
            return dp[nums.length - 1];
        } else {
            return MaxPre;
        }
        
        
    } 

    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        int [] nums = new int [] {2,7,9,3,1};
        
        System.out.println(solution.rob(nums));
    }
    
}
