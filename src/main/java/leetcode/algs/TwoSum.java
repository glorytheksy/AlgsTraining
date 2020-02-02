package leetcode.algs;

public class TwoSum {

    public int [] solution(int [] nums, int target) {
        if (null == nums) {
            throw new RuntimeException("");
        }
        
        if (1 == nums.length) {
            throw new RuntimeException("");
        }
        
        int p1 = 0;
        int p2 = nums.length - 1;
        
        while (p1 < p2) {            
            if (nums[p1] + nums[p2] == target) {
                return new int [] {nums[p1], nums[p2]};
            } else if (nums[p1] + nums[p2] < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return null;        
    }
    
    
}
