package leetcode.algs.cylic_sort;

/**
 * 
 * @author glorythesky
 * 找重复数
 *
 */
public class FindDuplicate {
	
    public int findDuplicate(int[] nums) {
    	if (null == nums) {
    		throw new RuntimeException();
    	}
		for (int i = 0; i < nums.length - 1; i++) {			
			while (i != nums[i] - 1) {
				if (nums[i] == nums[nums[i] - 1]) {
					return nums[i];
				}				
				this.swap(nums, i, nums[i] - 1);
			}
		}
		return nums[nums.length -1];
    }
    
    private void swap(int [] arr, int p1, int p2) {
        if (arr.length - 1 < p1 || arr.length - 1 < p2) {
            throw new RuntimeException("err");
        }
        
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
	
    public static void main(String[] args) {
		int [] nums = new int [] {3,1,3,4,2};
		FindDuplicate obj = new FindDuplicate();
		System.out.println(obj.findDuplicate(nums));
	}

}
