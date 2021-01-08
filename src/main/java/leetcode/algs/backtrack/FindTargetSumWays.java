package leetcode.algs.backtrack;


public class FindTargetSumWays {

	public int findTargetSumWays(int[] nums, int S) {
		int depth = 0;
		int curSum = 0;
		return this.backtrack(S, curSum, nums, depth);
	}

	public int backtrack(int S, int curSum, int[] nums, int depth) {
		if (depth == nums.length) {
			if (S == curSum) {
				return 1;
			} else {
				return 0;
			}
		} else {
			curSum += nums[depth];
			depth += 1;
			int left = this.backtrack(S, curSum, nums, depth);
			depth -= 1;
			curSum -= nums[depth];
			
			curSum += -nums[depth];
			depth += 1;
			int right = this.backtrack(S, curSum, nums, depth);
			depth -= 1;
			curSum -= -nums[depth];

			return left + right;
		}
	}

	public static void main(String[] args) {
		FindTargetSumWays solution = new FindTargetSumWays();
		int nums [] = new int [] {22,25,21,8,32,36,26,22,12,26,32,1,11,21,19,50,2,1,19,32};
		int S = 24;
		System.out.println(solution.findTargetSumWays(nums, S));
	}

}
