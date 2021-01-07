package dynamic_programming;


public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }
        
        // dp[i] 以  price[i + 1]为sell点的maxprofit 
        int [] dp = new int [prices.length];
        
        dp[0] = 0;
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                dp[i] = dp[i-1] + (prices[i] - prices[i-1]);
            } else {
                dp[i] = Math.max(dp[i-1] - (prices[i-1] -prices[i]), 0);
            }
            if (maxPro < dp[i]) {
                maxPro = dp[i];
            }
        }
        return maxPro;
    }
    
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
//        int[] prices = new int [] {0,1};
        int[] prices = new int [] {7,6,4,3,1};
        
        System.out.println(solution.maxProfit(prices));
    }
    
}
