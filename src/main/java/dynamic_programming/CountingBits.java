package dynamic_programming;

import utils.CommonUtils;

public class CountingBits {
    public int[] countBits(int num) {
        int  [] res = new int [num + 1];

        for (int i = 0; i < num + 1; i++) {
            res[i] = this.hammingWeight(i);
        }
        return res;

    }

    public int[] countBits2(int num) {
    	int dp[] = new int[num + 1];
    	dp[0] = 0;
    	int highestPos = 0;
        for (int i = 1; i < num + 1; i++) {
        	highestPos = this.highestBitPos(i);
        	dp[i] = dp[i - (int)Math.floor(Math.pow(2, highestPos))] + 1;
        }
    	
    	return dp;
    }
    
    private int highestBitPos(int num) {
    	int res = 0;
    	int mask = 1;
    	while (mask <= num) {
			res++;
    		mask = (mask<<1);
    	}
        return res - 1;    
    }
    
    private int hammingWeight(int n) {
    	int res = 0;
    	int mask = 1;
    	while (mask <= n) {
    		if (0 != (mask & n)) {
    			res++;
    		}
    		
    		mask = (mask<<1);
    	}
        return res;    
    }
    
    public static void main(String[] args) {
    	CountingBits solution = new CountingBits();
    	int num = 5;
    	CommonUtils.printArr(solution.countBits2(5));
	}
	
}
