package dynamic_programming;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        // dp[i] 表示以第 i + 1 个元素结尾的最大product
        int[] dp_max = new int[nums.length];
        dp_max[0] = nums[0];
        
        // dp[i] 表示以第 i + 1 个元素结尾的最小product
        int[] dp_min = new int[nums.length];
        dp_min[0] = nums[0];

        int maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp_max[i] = this.max(dp_max[i-1] * nums[i], dp_min[i-1]*nums[i], nums[i]);
            dp_min[i] = this.min(dp_max[i-1] * nums[i], dp_min[i-1]*nums[i], nums[i]);
            if (maxProduct < dp_max[i]) {
                maxProduct = dp_max[i];
            }
        }
        return maxProduct;
    }
    
    public int max(int i1, int i2, int i3) {
        int max = i1;
        if (i2 > max) {
            max = i2;
        }
        if (i3 > max) {
            max = i3;
        }
        return max;
    }

    public int min(int i1, int i2, int i3) {
        int min = i1;
        if (i2 < min) {
            min = i2;
        }
        if (i3 < min) {
            min = i3;
        }
        return min;
    }
    
    public static void main(String[] args) {
        MaximumProductSubarray solution = new MaximumProductSubarray();
        int [] nums = new int[] {2,-5,-2,-4,3};
        
        System.out.println(solution.maxProduct(nums));
    }
}
