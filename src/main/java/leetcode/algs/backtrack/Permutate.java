package leetcode.algs.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Permutate {
	

	/**
	 *  非回溯法
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> permute(int[] nums) {
    	if (null == nums) {
    		return null;
    	}
    	List<Integer> helper = new LinkedList<Integer>(); 
    	List<Integer> permu = new LinkedList<Integer>();
    	for (int num : nums) {
    		permu.add(num);
    	}
    	return this.permutation(helper, permu);
    }
	
    private List<List<Integer>> permutation(List<Integer> fixed, List<Integer> permu) {
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	if (null == permu || permu.isEmpty()) {
    		res.add(fixed);
    		return res;
    	}    	
    	if (1 == permu.size()) {
    		fixed.addAll(permu);
    		res.add(fixed);
    		return res;
    	}
    	
    	for (int i = 0; i < permu.size(); i++) {
    		int temp_ele = permu.remove(i);
    		List<Integer> head = new LinkedList<Integer>();
    		head.add(temp_ele);
    		List<List<Integer>> temp_permu = this.permutation(head, permu);
    		for (List<Integer> list : temp_permu) {
    			List<Integer> new_list = new LinkedList<Integer>();
    			new_list.addAll(fixed);
    			new_list.addAll(list);
    			res.add(new_list);
    		}    		
    		permu.add(i, temp_ele);
    	}	
    	return res;
    }
    
    
    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        
        // 过程省略
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int flags [] = new int [nums.length];
        List<Integer> route = new ArrayList<Integer>();

        this.backtrack(nums, flags, res, route);
        return res;
    }
    
    private void backtrack(int [] nums, int [] flags, List<List<Integer>> res, List<Integer> route) {
        if (nums.length == route.size()) {
            List<Integer> temp_route = new ArrayList<Integer>();
            for (int e : route) {
                temp_route.add(e);
            }
            res.add(temp_route);
            return;
        }
        
        for (int i=0; i<flags.length; i++) {
            if (1 == flags[i]) {
                continue;
            }
            
            route.add(nums[i]);
            flags[i] = 1;
            this.backtrack(nums, flags, res, route);
            flags[i] = 0;
            route.remove(route.size() - 1);
        }
    }
    
    public static void main(String[] args) {
		
    	Permutate obj = new Permutate();
    	
    	int [] nums = new int [] {1,2,3,4};
    	
    	List<List<Integer>> lists = obj.permute2(nums);
    	for (List<Integer> list : lists) {
    		for (int e : list) {
    			System.out.print(e + " ");
    			
    		}
    		System.out.println();
    	}
	}
    
}
