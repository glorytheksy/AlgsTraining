package dynamic_programming;

public class BestTimetoBuyandSellStockwithCooldown {

	public int maxProfit(int[] prices) {
		if (null == prices || 0 == prices.length) {
			return 0;
		}
		/*
		 * dp[i][0] 第i+1天 状态为持有股票 此时对应最大收益 
		 * dp[i][1] 第i+1天 状态为不持有股票 xxxx 
		 * dp[i][2] 第i+1天
		 * 状态为不持有股票且处于cooldown xxxx
		 */
		int dp[][] = new int[prices.length][3];
		dp[0][0] = -prices[0];
		dp[0][1] = 0;
		dp[0][2] = -200000;

		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
			dp[i][2] = dp[i - 1][0] + prices[i];
		}
		return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
	}


	public static void main(String[] args) {
		BestTimetoBuyandSellStockwithCooldown solution = new BestTimetoBuyandSellStockwithCooldown();
//      int[] prices = new int [] {0,1};
		int[] prices = new int[] {1,2,3,0,2};

		System.out.println(solution.maxProfit(prices));
	}

}
