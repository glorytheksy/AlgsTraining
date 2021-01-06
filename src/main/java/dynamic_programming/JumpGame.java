package dynamic_programming;


public class JumpGame {

    public boolean canJump(int[] nums) {
        if (0 == nums.length || 1 == nums.length) {
            return true;
        }
        
        int len = nums.length;   
        boolean [] dp = new boolean [len];
        
        for (int i = 1; i <= len - 1; i++) {
            if (0 == nums[len - 1 - i]) {
                dp[len - 1 -i] = false;
            } else if (i <= nums[len - 1 - i]) {
                dp[len - 1 - i] = true;
            } else {
                dp[len - 1 - i] = false;
                for (int j = len - i; j <= Math.min(len - 2, len - 1 - i + nums[len - 1 - i]); j++) {
                    if (true == dp[j]) {
                        dp[len - 1 - i] = true;
                    }
                }
            }            
        }
        return dp[0];
        
    }
    
    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int [] nums = new int[] {3,2,1,0,4};
        System.out.println(solution.canJump(nums));
    }
    
}
