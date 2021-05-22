package dynamic_programming;
/**
 * 
 * @author glorythesky
 *
 * 这题太tricky了，而且是只能用官方给的那种方式解题比较简单,
 * 我觉得自己的方式不是不能解，但是由于形式问题（官方是一边遍历一边更新，我是更新了一遍找出最值信息之后，再更新）我的解会异常冗余
 *
 *
 */
public class NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
    	return -1;
    }
    
	public static void main(String[] args) {
	    NumberofLongestIncreasingSubsequence solution = new NumberofLongestIncreasingSubsequence();
	    int [] nums = new int [] {1,2,4,3,5,4,7,2};
	    System.out.println(solution.findNumberOfLIS(nums));
	}
    
    
}
