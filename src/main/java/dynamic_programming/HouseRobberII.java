package dynamic_programming;


public class HouseRobberII {

    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        
        return Math.max(this.rob(nums, 0, nums.length - 2), this.rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] origin_nums, int start, int end) {
        int [] nums = new int [end - start + 1];
        for (int i = 0; i <= end - start; i++) {
            nums[i] = origin_nums[i + start];
        }
        
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
        HouseRobberII solution = new HouseRobberII();
        int [] nums = new int [] {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
        
        System.out.println(solution.rob(nums));
    }
}
